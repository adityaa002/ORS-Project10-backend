package com.rays.common;

import java.util.List;

/**
 * Generic Data Access Object (DAO) interface.
 * <p>
 * Defines standard CRUD operations and search methods for all DTO entities.
 * Implementations should provide concrete logic using JPA/Hibernate.
 * </p>
 *
 * @param <T> DTO type extending BaseDTO
 *
 * @author Aditya
 * @version 1.0
 */
public interface BaseDAOInt<T extends BaseDTO> {

    /**
     * Adds a new record to the database.
     *
     * @param dto         DTO object to be persisted
     * @param userContext current user context
     * @return generated primary key ID
     */
    public long add(T dto, UserContext userContext);

    /**
     * Updates an existing record in the database.
     *
     * @param dto         DTO object to be updated
     * @param userContext current user context
     */
    public void update(T dto, UserContext userContext);

    /**
     * Deletes a record from the database.
     *
     * @param dto         DTO object to be deleted
     * @param userContext current user context
     */
    public void delete(T dto, UserContext userContext);

    /**
     * Finds a record by its primary key.
     *
     * @param pk          primary key ID
     * @param userContext current user context
     * @return DTO object or null if not found
     */
    public T findByPK(long pk, UserContext userContext);

    /**
     * Finds a record by a unique key attribute.
     *
     * @param attribute   unique attribute name
     * @param val         attribute value
     * @param userContext current user context
     * @return DTO object or null if not found
     */
    public T findByUniqueKey(String attribute, Object val, UserContext userContext);

    /**
     * Searches records with pagination.
     *
     * @param dto         DTO object containing search criteria
     * @param pageNo      page number
     * @param pageSize    number of records per page
     * @param userContext current user context
     * @return list of matching records
     */
    public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext);

    /**
     * Searches records without pagination.
     *
     * @param dto         DTO object containing search criteria
     * @param userContext current user context
     * @return list of matching records
     */
    public List<T> search(T dto, UserContext userContext);
}
