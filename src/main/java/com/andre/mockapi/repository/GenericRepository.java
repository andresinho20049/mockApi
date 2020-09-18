package com.andre.mockapi.repository;

import java.util.List;

public interface GenericRepository<T> {
	
	public List<T> jsonToJava(String path) throws Exception;
	
	public String javaToJson(List<T> instance) throws Exception;
	
 	
}
