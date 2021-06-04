package com.revature.repos;

import java.util.List;

public interface GenericRepository <T>{
	//implementing CRUD operations to create
	//read update and destroy.
	public T add(T t);
	public T getById(Integer id);
	public List<T> getAll();
	public boolean update(T change);
	public boolean delete(T t);
	
}
