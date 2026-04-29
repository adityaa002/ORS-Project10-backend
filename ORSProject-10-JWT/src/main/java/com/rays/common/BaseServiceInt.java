package com.rays.common;

import java.util.List;

import com.rays.exception.DatabaseException;

/**
 * Generic Base Service Interface providing common CRUD operations
 * for all DTOs extending {@link BaseDTO}.
 *
 * @param <T> the type of DTO
 */
public interface BaseServiceInt<T extends BaseDTO> {

    /**
     * Adds a new record in the database.
     *
     * @param dto the DTO to be added
     * @param userContext contains logged-in user details for auditing
     * @return generated primary key of the inserted record
     */
    public long add(T dto, UserContext userContext);

    /**
     * Updates an existing record in the database.
     *
     * @param dto the DTO containing updated data
     * @param userContext contains logged-in user details for auditing
     */
    public void update(T dto, UserContext userContext);

    /**
     * Saves the record (insert or update).
     * If DTO has an ID, it updates; otherwise, it adds a new record.
     *
     * @param dto the DTO to be saved
     * @param userContext contains logged-in user details for auditing
     * @return primary key of the saved record
     */
    public long save(T dto, UserContext userContext);

    /**
     * Deletes a record by its primary key.
     *
     * @param id the primary key of the record to be deleted
     * @param userContext contains logged-in user details for auditing
     * @return deleted DTO object
     * @throws DatabaseException if any database constraint or error occurs
     */
    public T delete(long id, UserContext userContext) throws DatabaseException;

    /**
     * Finds a record by its primary key.
     *
     * @param id the primary key
     * @param userContext contains logged-in user details
     * @return DTO object if found, otherwise null
     */
    public T findById(long id, UserContext userContext);

    /**
     * Finds a record based on a unique attribute.
     *
     * @param attribute the field name (e.g., email, loginId)
     * @param val the value of the attribute
     * @param userContext contains logged-in user details
     * @return DTO object if found, otherwise null
     */
    public T findByUniqueKey(String attribute, String val, UserContext userContext);

    /**
     * Searches records with pagination support.
     *
     * @param dto contains search criteria
     * @param pageNo page number (starting from 1)
     * @param pageSize number of records per page
     * @param userContext contains logged-in user details
     * @return list of matching records
     */
    public List search(T dto, int pageNo, int pageSize, UserContext userContext);

    /**
     * Searches records without pagination.
     *
     * @param dto contains search criteria
     * @param userContext contains logged-in user details
     * @return list of matching records
     */
    public List search(T dto, UserContext userContext);
    
}