package br.com.elo7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nasaservices")
public class SondaController {
	
	/**
	 * Serviço responsável por criar uma nova Sonda
	 * TODO - Finalizar assinatura....
	 */
	@RequestMapping(value = "/v1/sonda", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<String> criarSonda() {
		return new ResponseEntity<String>("ok", HttpStatus.CREATED);
	}
	
	/**
	 * Serviço responsável por atualizar (movimentar) uma nova Sonda
	 * TODO - Finalizar assinatura....
	 */
	@RequestMapping(value = "/v1/sonda", method = RequestMethod.PUT)
	@ResponseBody
	ResponseEntity<String> movimentarSonda() {
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	/**
	 * Serviço responsável por destruir (remover do planalto) uma Sonda
	 * TODO - Finalizar assinatura....
	 */
	@RequestMapping(value = "/v1/sonda", method = RequestMethod.DELETE)
	@ResponseBody
	ResponseEntity<String> destruirSonda() {
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

}
