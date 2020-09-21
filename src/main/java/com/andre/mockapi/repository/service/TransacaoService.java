package com.andre.mockapi.repository.service;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import com.andre.mockapi.models.Transacao;
import com.andre.mockapi.repository.TransacaoRepository;
import com.google.gson.reflect.TypeToken;

@Repository
public class TransacaoService extends GenericService<Transacao> implements TransacaoRepository {

	private final Logger logger = Logger.getLogger(TransacaoService.class);
	List<Transacao> list;
	
	
	public List<Transacao> getTransacao(Integer userId) throws Exception {
		//ta
		String path = "transacoes/" + userId + "-mock";
		try { 
			Type listType = new TypeToken<ArrayList<Transacao>>() {
			}.getType();
			list = this.parseJson(path, listType);
			logger.info("IdUsers: " + userId + " - com " + list.size() + " registros!");
		} catch(FileNotFoundException e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "{\"status\": \"400\",\"error\": \"ERROR: ID " + userId + " nao encontrado\"}");
		}
		return list;
	}

	public List<Transacao> getTransacao(Integer userId, Integer ano) throws Exception {
		this.getTransacao(userId);
		List<Transacao> listAno = new ArrayList<Transacao>();
		
		for (Transacao transacao : list) {
			Integer transacaoAno = this.convertTimeWithTimeZome(transacao.getData()).get(Calendar.YEAR);
			if (transacaoAno.equals(ano)) {
				listAno.add(transacao);
			}
		}
		logger.info("Ano: " + ano + " - com " + listAno.size() + " registros!");
		
		return listAno;
	}
	
	public List<Transacao> getTransacao(Integer userId, Integer ano, Integer mes) throws Exception {
		//ta
		this.getTransacao(userId);
		List<Transacao> listAnoMes = new ArrayList<Transacao>();
		
		for (Transacao transacao : list) {
			Integer transacaoAno = this.convertTimeWithTimeZome(transacao.getData()).get(Calendar.YEAR);
			Integer transacaoMes = this.convertTimeWithTimeZome(transacao.getData()).get(Calendar.MONTH) + 1;
			if (transacaoAno.equals(ano) && transacaoMes.equals(mes)) {
				listAnoMes.add(transacao);
			}
		}
		logger.info("Ano/mes: " + ano + "/" + mes + " - com " + listAnoMes.size() + " registros!");
		
		return listAnoMes;
	}

	@Override
	public void save(Integer userId, Transacao transacao)  {
		transacao.setDuplicated(false);
		try {
			this.getTransacao(userId);
			for (Transacao t : list) {
				if (transacao.getDescricao().equals(t.getDescricao()) &&
					transacao.getData().equals(t.getData())	&&
					transacao.getValor().equals(t.getValor())) {
						transacao.setDuplicated(true);
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			list = new ArrayList<>();
		} 
		
		list.add(transacao);
		String path = "transacoes/" + userId + "-mock";
		this.saveJson(list, path);		
		
	}
}
