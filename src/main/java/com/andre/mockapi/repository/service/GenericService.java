package com.andre.mockapi.repository.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

import com.andre.mockapi.repository.GenericRepository;
import com.google.gson.Gson;

public abstract class GenericService<T> implements GenericRepository<T> {

	private final Logger logger = Logger.getLogger(GenericService.class);
	private List<T> list;

	@Override
	public List<T> parseJson(String fileJson, Type listType) throws Exception {
		logger.info("iniciando Service");

		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		String directory = path + "/mock/" + fileJson + ".json";

		logger.info("Diretorio: " + directory);

		FileReader fileReader = new FileReader(directory);

		Gson gson = new Gson();
		list = gson.fromJson(fileReader, listType);
		fileReader.close();

		return list;
	}
	
	@Override
	public void saveJson(List<T> list, String fileJson) {
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		String directory = path + "/mock/" + fileJson + ".json";
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		FileWriter arq;
		PrintWriter gravarArq;
		try {
			arq = new FileWriter(directory);
			gravarArq = new PrintWriter(arq);
			gravarArq.println(json);

			arq.close();
		} catch (IOException e) {
			logger.error(e);
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "{\"status\": \"400\",\"error\": \"ERROR: Nao foi possivel salvar o arquivo\"}");
		}
	}

	@Override
	public MultiValueMap<String, String> errorHeader(HttpClientErrorException e) {
		MultiValueMap<String, String> mapError = new LinkedMultiValueMap<String, String>();
		mapError.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		mapError.add("Content", e.getStatusText());
		mapError.add("Keep-Alive", "10");
		return mapError;
	}

	@Override
	public Calendar convertTimeWithTimeZome(Long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		cal.setTimeInMillis(time);
		return cal;
	}

}
