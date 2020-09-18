package com.andre.mockapi.repository;

import java.io.FileNotFoundException;
import java.util.List;

import com.andre.mockapi.models.Transacao;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public interface TransacaoRepository extends GenericRepository<Transacao>{
	
	public List<Transacao> getTransacao(Integer userId) throws JsonIOException, JsonSyntaxException, FileNotFoundException; 

}
