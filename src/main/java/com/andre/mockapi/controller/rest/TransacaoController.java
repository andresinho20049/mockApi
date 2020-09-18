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

import com.andre.mockapi.models.Transacao;
import com.andre.mockapi.repository.service.TransacaoService;

@RestController
public class TransacaoController {

	private final Logger logger = Logger.getLogger(TransacaoController.class);
	private TransacaoService service = null;
	
	@RequestMapping(value = "/api/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Transacao>> findByIdUser(@PathVariable("id") Integer idUser) {
		logger.debug("Logging...");
		
		try {
			service = new TransacaoService();
			List<Transacao> transacoes = service.getTransacao(idUser);
			logger.info("service.getByIdUser: " + idUser + " - concluido com sucesso!!!");
			
			return new ResponseEntity<List<Transacao>>(transacoes, HttpStatus.OK);
		} catch(Exception e) {
			logger.error(e + " - " + e.getCause());
			return new ResponseEntity<List<Transacao>>(HttpStatus.BAD_REQUEST);
		}
	}
}
