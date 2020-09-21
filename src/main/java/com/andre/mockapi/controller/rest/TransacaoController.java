package com.andre.mockapi.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.andre.mockapi.models.Transacao;
import com.andre.mockapi.repository.service.TransacaoService;

@RestController
@RequestMapping(value = "/api")
public class TransacaoController {

	private final Logger logger = Logger.getLogger(TransacaoController.class);
	
	@Autowired
	TransacaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Transacao>> findByIdUser(@PathVariable("id") Integer idUser) throws Exception {
		logger.debug("Logging...");

		List<Transacao> transacoes;
		try {
			transacoes = service.getTransacao(idUser);
			logger.info("Busca IdUser: " + idUser + " - concluido com sucesso!!!");
			return new ResponseEntity<List<Transacao>>(transacoes, HttpStatus.OK);
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<List<Transacao>>(service.errorHeader(e) , e.getStatusCode());
		} 
	}

	@RequestMapping(value = "/{id}/transacoes/{ano}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Transacao>> findByIdUser(@PathVariable("id") Integer idUser,
			@PathVariable("ano") Integer ano) throws Exception {
		logger.debug("Logging...");

		List<Transacao> transacoes;
		try {
			transacoes = service.getTransacao(idUser, ano);
			logger.info("Busca IdUser: " + idUser + " - Ano: " + ano + " - concluido com sucesso!!!");
			return new ResponseEntity<List<Transacao>>(transacoes, HttpStatus.OK);
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<List<Transacao>>(service.errorHeader(e) , e.getStatusCode());
		} 

	}

	@RequestMapping(value = "/{id}/transacoes/{ano}/{mes}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Transacao>> findByIdUser(@PathVariable("id") Integer idUser, 
			@PathVariable("ano") Integer ano,
			@PathVariable("mes") Integer mes) throws Exception {
		logger.debug("Logging...");

		List<Transacao> transacoes;
		try {
			//ba
			transacoes = service.getTransacao(idUser, ano, mes);
			logger.info("Busca IdUser: " + idUser + " - Ano: " + ano + " - mes: " + mes +  " - concluido com sucesso!!!");
			return new ResponseEntity<List<Transacao>>(transacoes, HttpStatus.OK);
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<List<Transacao>>(service.errorHeader(e) , e.getStatusCode());
		} 

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@PathVariable("id") Integer idUser, @RequestBody @Valid Transacao transacao) throws Exception {
		logger.debug("Logging...");

		try {
			service.save(idUser, transacao);
			logger.info("idUser " + idUser + " Salvo com sucesso!");
			return new ResponseEntity<String>("{\"status\": \"200 - OK\"}", HttpStatus.OK);
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<String>(service.errorHeader(e) , e.getStatusCode());
		} 

	}
}
