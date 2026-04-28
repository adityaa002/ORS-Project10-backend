package com.rays.ctl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.MarksheetDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Transactional
@RestController
@RequestMapping(value = "Jasper")
public class JasperCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

    @Value("${report.path}")
    private String reportPath;

    @PersistenceContext
    protected EntityManager entityManager;

    // Cached compiled report — har request pe compile nahi hoga
    private JasperReport cachedReport = null;

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public void display(HttpServletResponse response) throws JRException, SQLException, IOException {

        System.out.println("JASPER CONTROLLER — reportPath: " + reportPath);

        // Step 1: Load input stream
        InputStream input = loadReportStream();

        if (input == null) {
            System.err.println("ERROR: Report file not found at path: " + reportPath);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Report file not found");
            return;
        }

        // Step 2: Compile (cached)
        if (cachedReport == null) {
            System.out.println("Compiling report for first time...");
            cachedReport = JasperCompileManager.compileReport(input);
            System.out.println("Report compiled successfully.");
        } else {
            input.close(); // stream ka kaam ho gaya
        }

        // Step 3: DB connection via Hibernate
        SessionFactory sessionFactory = entityManager
                .getEntityManagerFactory()
                .unwrap(SessionFactory.class);

        Connection conn = sessionFactory
                .getSessionFactoryOptions()
                .getServiceRegistry()
                .getService(ConnectionProvider.class)
                .getConnection();

        // Step 4: Fill report
        Map<String, Object> params = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(cachedReport, params, conn);

        // Step 5: Export to PDF
        byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

        // Step 6: Write response
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=report.pdf");
        response.getOutputStream().write(pdf);
        response.getOutputStream().flush();

        System.out.println("Report generated successfully. Size: " + pdf.length + " bytes");
    }

    /**
     * classpath: aur file: dono handle karta hai
     * Spring Boot fat JAR ke saath ClassPathResource reliable hai
     */
    private InputStream loadReportStream() throws IOException {
        if (reportPath.startsWith("classpath:")) {
            String path = reportPath.replace("classpath:", "");
            ClassPathResource resource = new ClassPathResource(path);
            System.out.println("Loading from classpath: " + path);
            System.out.println("Resource exists: " + resource.exists());
            return resource.getInputStream();

        } else {
            // Docker volume mount ya absolute path
            java.io.File file = new java.io.File(reportPath);
            System.out.println("Loading from filesystem: " + file.getAbsolutePath());
            System.out.println("File exists: " + file.exists());
            return new java.io.FileInputStream(file);
        }
    }
}