package com.revature.repos;

import java.util.List;

public interface GenericRepository <T>{
	//implementing CRUD operations to create
	//read update and destroy.
	public T add(T t);
	public T getById(Integer id);
	public List<T> getAll();
	public void update(T change);
	public void delete(T t);
	
}
