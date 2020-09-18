package com.andre.mockapi.controller.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.andre.mockapi.models.Transacao;
import com.andre.mockapi.repository.service.TransacaoService;

@RestController
public class TransacaoController {

	private final Logger logger = Logger.getLogger(TransacaoController.class);
	private TransacaoService service = null;

	@RequestMapping(value = "/api/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> findByIdUser(@PathVariable("id") Integer idUser) {
		logger.debug("Logging...");

		try {
			service = new TransacaoService();
			List<Transacao> transacoes = service.getTransacao(idUser);
			String json = service.javaToJson(transacoes);
			
			logger.info("service IdUser: " + idUser + " - concluido com sucesso!!!");
			
			return new ResponseEntity<String>(json, HttpStatus.OK);

		} catch (HttpClientErrorException e) {
			logger.error(e);
			return new ResponseEntity<String>(e.getStatusText(), e.getStatusCode());
		} catch (Exception e) {
			logger.error(e);
			return new ResponseEntity<String>("{\"status\": \"ERROR: " + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/{id}/transacoes/{ano}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> findByIdUser(@PathVariable("id") Integer idUser,
			@PathVariable("ano") String ano) {
		logger.debug("Logging...");

		try {
			service = new TransacaoService();
			List<Transacao> transacoes = service.getTransacao(idUser, ano);
			String json = service.javaToJson(transacoes);
			
			logger.info("service IdUser: " + idUser + " - concluido com sucesso!!!");

			return new ResponseEntity<String>(json, HttpStatus.OK);

		} catch (HttpClientErrorException e) {
			logger.error(e);
			return new ResponseEntity<String>(e.getStatusText(), e.getStatusCode());
		} catch (Exception e) {
			logger.error(e);
			return new ResponseEntity<String>("{\"status\": \"ERROR: " + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/{id}/transacoes/{ano}/{mes}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> findByIdUser	(
			@PathVariable("id") Integer idUser, 
			@PathVariable("ano") String ano, 
			@PathVariable("ano") String mes) {
		logger.debug("Logging...");

		try {
			service = new TransacaoService();
			List<Transacao> transacoes = service.getTransacao(idUser, ano, mes);
			String json = service.javaToJson(transacoes);
			
			logger.info("service IdUser: " + idUser + " - concluido com sucesso!!!");

			return new ResponseEntity<String>(json, HttpStatus.OK);

		} catch (HttpClientErrorException e) {
			logger.error(e);
			return new ResponseEntity<String>(e.getStatusText(), e.getStatusCode());
		} catch (Exception e) {
			logger.error(e);
			return new ResponseEntity<String>("{\"status\": \"ERROR: " + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
