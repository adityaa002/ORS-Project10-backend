package com.rays.common;

/**
 * Base Form class used for transferring data between UI and DTO.
 * <p>
 * Provides common fields such as ID, audit information, pagination, and batch
 * operations. All form classes should extend this class to inherit standard
 * properties and utility methods.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public class BaseForm {

    /** Primary key ID */
    protected Long id;

    /** User who created the record */
    protected String createdBy;

    /** User who last modified the record */
    protected String modifiedBy;

    /** Timestamp when the record was created */
    protected long createdDatetime;

    /** Timestamp when the record was last modified */
    protected long modifiedDatetime;

    /** Array of IDs for batch operations (e.g., deleteMany) */
    private Long[] ids;

    /** Current page number for pagination */
    private int pageNo = 0;

    /** Page size for pagination */
    private int pageSize = 5;

    /** Operation type (e.g., save, update, delete) */
    private String operation;

    // ---------------- Standard Getters and Setters ---------------- //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Converts form data to a DTO object.
     * <p>
     * By default, returns null. Subclasses should override this method to
     * provide proper DTO conversion.
     * </p>
     *
     * @return DTO object
     */
    public BaseDTO getDto() {
        return null;
    }

    /**
     * Initializes a DTO with form values.
     * <p>
     * Sets the ID if available, otherwise assigns null.
     * </p>
     *
     * @param dto DTO object to initialize
     * @param <T> type extending BaseDTO
     * @return initialized DTO
     */
    public <T extends BaseDTO> T initDTO(T dto) {
        if (id != null && id > 0) {
            dto.setId(id);
        } else {
            dto.setId(null);
        }
        return dto;
    }
}
