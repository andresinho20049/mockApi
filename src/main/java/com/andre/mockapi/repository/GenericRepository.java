package com.andre.mockapi.repository;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

public interface GenericRepository<T> {
	public List<T> parseJson(String path, Type listType) throws Exception;	
	public MultiValueMap<String, String> errorHeader(HttpClientErrorException e);
	public Calendar convertTimeWithTimeZome(Long time);
	public void saveJson(List<T> list, String fileJson);
 	
}
