package com.andre.mockapi.repository.service;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.andre.mockapi.repository.GenericRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public abstract class GenericService<T> implements GenericRepository<T> {

	private final Logger logger = Logger.getLogger(GenericService.class);
	private ArrayList<T> list = null;

	public List<T> jsonToJava(String fileJson) throws Exception {
		logger.info("iniciando Service");

		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		String directory = path + "\\mock\\" + fileJson;

		logger.info("Diretorio: " + directory);

		FileReader fileReader = new FileReader(directory);

		Gson gson = new Gson();
		Type listType = new TypeToken<List<T>>() {
		}.getType();
		list = gson.fromJson(fileReader, listType);
		fileReader.close();

		return list;
	}

	public String javaToJson(List<T> instance) throws Exception {
		Gson gson = new Gson();
		return gson.toJson(instance);
	}

}
