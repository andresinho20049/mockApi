package com.andre.mockapi.repository.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import com.andre.mockapi.models.Transacao;
import com.andre.mockapi.repository.TransacaoRepository;

@Repository
public class TransacaoService extends GenericService<Transacao> implements TransacaoRepository {

	@Override
	public List<Transacao> getTransacao(Integer userId) throws Exception {
		String path = "\\transacoes\\" + userId + "-mock.json";

		List<Transacao> list = null;
		try { 
			list = this.jsonToJava(path);
		} catch(FileNotFoundException e) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "{\"status\": \"ERROR: ID " + userId + " nao encontrado\"}");
		}
		return list;
	}

	@Override
	public List<Transacao> getTransacao(Integer userId, String ano) 
			throws Exception {

		List<Transacao> newList = new ArrayList<Transacao>();
		List<Transacao> list = this.getTransacao(userId);
		for (Transacao transacao : list) {
			String transacaoAno = transacao.getData().toString().substring(0, 3);
			if (transacaoAno.equals(ano)) {
				newList.add(transacao);
			}
		}
		
		return newList;
	}

	@Override
	public List<Transacao> getTransacao(Integer userId, String ano, String mes)
			throws Exception {
		
		List<Transacao> newList = new ArrayList<Transacao>();
		List<Transacao> list = this.getTransacao(userId);
		for (Transacao transacao : list) {
			String transacaoAno = transacao.getData().toString().substring(0, 3);
			String transacaoMes = transacao.getData().toString().substring(4, 5);
			if (transacaoAno.equals(ano) && transacaoMes.equals(mes)) {
				newList.add(transacao);
			}
		}
		
		return newList;
	}

}
