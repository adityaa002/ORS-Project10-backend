package com.rays.common;

import java.util.List;

import com.rays.exception.DatabaseException;

public interface BaseServiceInt<T extends BaseDTO> {

	public long add(T dto, UserContext userContext);

	public void update(T dto, UserContext userContext);

	public long save(T dto, UserContext userContext);

	public T delete(long id, UserContext userContext) throws DatabaseException;

	public T findById(long id, UserContext userContext);

	public T findByUniqueKey(String attribute, String val, UserContext userContext);

	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	public List search(T dto, UserContext userContext);
	
}