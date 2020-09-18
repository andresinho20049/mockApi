package com.andre.mockapi.repository;

import java.util.List;

import com.andre.mockapi.models.Transacao;

public interface TransacaoRepository extends GenericRepository<Transacao>{
	
	public List<Transacao> getTransacao(Integer userId) throws Exception; 
	
	public List<Transacao> getTransacao (Integer userId, String ano) throws Exception;
	
	public List<Transacao> getTransacao (Integer userId, String ano, String mes) throws Exception;

}
