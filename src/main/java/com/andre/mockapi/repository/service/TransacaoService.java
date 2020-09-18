package com.andre.mockapi.repository.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.andre.mockapi.models.Transacao;
import com.andre.mockapi.repository.TransacaoRepository;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

@Repository
public class TransacaoService extends GenericService<Transacao> implements TransacaoRepository {

	@Override
	public List<Transacao> getTransacao(Integer userId) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		String path = "\\transacoes\\" + userId + "-mock.json";
		List<Transacao> list = this.parseJson(path);
		return list;
	}

}
