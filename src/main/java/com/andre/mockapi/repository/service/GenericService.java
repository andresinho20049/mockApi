package com.andre.mockapi.repository.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.apache.log4j.Logger;

import com.andre.mockapi.repository.GenericRepository;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public abstract class GenericService<T> implements GenericRepository<T>{
	
	private final Logger logger = Logger.getLogger(GenericService.class);
	private List<T> list = null;

	public List<T> parseJson(String fileJson) throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		logger.info("iniciando Service");

		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		String directory = path + "\\mock\\" + fileJson;

		logger.info("Diretorio: " + directory);

		FileReader fileReader = new FileReader(directory);

		Gson gson = new Gson();
		Type listType = new TypeToken<List<T>>() {
		}.getType();
		list = gson.fromJson(fileReader, listType);

		logger.info("Parse Json com sucesso!!!");
		
		return list;
	}
	
}
