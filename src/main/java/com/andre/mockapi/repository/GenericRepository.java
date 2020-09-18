package com.andre.mockapi.repository;

import java.io.FileNotFoundException;
import java.util.List;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public interface GenericRepository<T> {
	
	public List<T> parseJson(String path) throws JsonIOException, JsonSyntaxException, FileNotFoundException;
	
}
