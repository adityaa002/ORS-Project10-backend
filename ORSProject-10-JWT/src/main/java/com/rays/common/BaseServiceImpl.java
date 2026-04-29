package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.exception.DatabaseException;
import com.rays.exception.DuplicateRecordException;

/**
 * Generic Base Service Implementation providing common CRUD operations.
 * This class uses a generic DAO layer to perform database interactions.
 *
 * @param <T> the DTO type extending BaseDTO
 * @param <D> the DAO type extending BaseDAOInt
 */
public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

	/**
	 * Generic DAO injected by Spring
	 */
	@Autowired
	protected D baseDao;

	/**
	 * Adds a new record.
	 *
	 * @param dto the DTO to be added
	 * @param userContext user context for auditing
	 * @return generated primary key
	 */
	@Transactional(readOnly = false)
	public long add(T dto, UserContext userContext) {
		long pk = baseDao.add(dto, userContext);
		return pk;
	}

	/**
	 * Updates an existing record.
	 * Preserves createdBy and createdDatetime fields from old record.
	 *
	 * @param dto the DTO with updated values
	 * @param userContext user context for auditing
	 * @throws DuplicateRecordException if duplicate record found
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto, UserContext userContext) throws DuplicateRecordException {

		T oldDto = baseDao.findByPK(dto.getId(), userContext);

		if (oldDto != null) {
			dto.setCreatedBy(oldDto.getCreatedBy());
			dto.setCreatedDatetime(oldDto.getCreatedDatetime());
		}

		baseDao.update(dto, userContext);
	}

	/**
	 * Saves the record (insert or update).
	 *
	 * @param dto the DTO to be saved
	 * @param userContext user context for auditing
	 * @return primary key of saved record
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto, UserContext userContext) {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto, userContext);
		} else {
			id = add(dto, userContext);
		}
		return id;
	}

	/**
	 * Finds a record by primary key.
	 *
	 * @param id the primary key
	 * @param userContext user context
	 * @return DTO if found, else null
	 */
	@Transactional(readOnly = true)
	public T findById(long id, UserContext userContext) {
		T dto = baseDao.findByPK(id, userContext);
		return dto;
	}

	/**
	 * Deletes a record by ID.
	 *
	 * @param id the primary key of record
	 * @param userContext user context
	 * @return deleted DTO
	 * @throws DatabaseException if record not found or deletion fails
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public T delete(long id, UserContext userContext) throws DatabaseException {
		T dto = findById(id, userContext);
		if (dto == null) {
			throw new DatabaseException("Record Not found ");
		}
		baseDao.delete(dto, userContext);
		return dto;
	}

	/**
	 * Finds a record using a unique key.
	 *
	 * @param attribute field name (e.g., email)
	 * @param val value of the field
	 * @param userContext user context
	 * @return DTO if found, else null
	 */
	@Transactional(readOnly = true)
	public T findByUniqueKey(String attribute, String val, UserContext userContext) {
		T dto = baseDao.findByUniqueKey(attribute, val, userContext);
		return dto;
	}

	/**
	 * Searches records with pagination.
	 *
	 * @param dto search criteria
	 * @param pageNo page number
	 * @param pageSize records per page
	 * @param userContext user context
	 * @return list of matching records
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
		return baseDao.search(dto, pageNo, pageSize, userContext);
	}

	/**
	 * Searches records without pagination.
	 *
	 * @param dto search criteria
	 * @param userContext user context
	 * @return list of matching records
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, UserContext userContext) {
		return baseDao.search(dto, userContext);
	}

}