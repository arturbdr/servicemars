package br.com.elo7.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo7.domain.to.PlateauTO;
import br.com.elo7.domain.to.ProbeTO;
import br.com.elo7.services.NasaServices;

@RestController
@RequestMapping("nasaservices")
public class ProbeController {
	
	@Autowired
	private NasaServices nasaServices;
	
	/**
	 * Serviço responsável por movimentar uma Sonda com base. Para localização da Sonda, utiliza seu ID.
	 * É necessário enviar as coordenadas para que a locomoção ocorra corretamente.
	 * Caso a posição de locomoção extrapole os limites do Planalto (Plateau) o serviço retornará erro.
	 * Para que seja realizada a locamoção de qualquer Sonda, é necessário que o Planalto este definido previamente.
	 * 
	 * <i>Esse serviço é utilitário.</i>
	 * @return ProbeTO - Contendo a localização final da Sonda após sua movimentação (caso essa tenha ocorrido com sucesso). 
	 * 
	 */
	@RequestMapping(value = "/v1/{id}/move", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ProbeTO> moveProbe(ProbeTO probeTO) {
		ProbeTO probe = null;
		return new ResponseEntity<ProbeTO>(probe, HttpStatus.CREATED);
	}
	
	/**
	 * Serviço responsável por definir o tamanho do Planalto.
	 * Caso o planalto já tenha sido definido previamente, esse serviço retornará um erro.
	 * 
	 * <i>Esse serviço é utilitário.</i>
	 * @return Status informando se o serviço foi executado com sucesso (200) ou com erro (500) 
	 * 
	 */
	@RequestMapping(value = "/v1/{id}/move", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createPlateau(PlateauTO plateauTO ) {
		return new ResponseEntity<String>(HttpStatus.CREATED.name(), HttpStatus.CREATED);
	}
	
	/**
	 * Serviço responsável por destruir (remover do planalto) uma Sonda
	 * 
	 * <i>Esse serviço é utilitário.</i>
	 * @return Um Status informando se o serviço foi executado com sucesso (200) ou com erros (500).
	 */
	@RequestMapping(value = "/v1/probe", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> destruirSonda() {
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	/**
	 * Serviço responsável por movimentar Sondas a partir da definição do Plateau. 
	 * É necessário enviar as coordenadas para que a locomoção ocorra corretamente.
	 * Caso a posição de locomoção extrapole os limites do Planalto (Plateau) o serviço retornará erro (500).
	 * 
	 * @return List<ProbeTO> - Contendo a localização final de cada Sonda após respectiva locomoção. 
	 * Caso alguma Sonda não tenha conseguido se locomover corretamente, ela retornará ao estado original. 
	 * 
	 */
	@RequestMapping(value = "/v1/moveProbes", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<List<ProbeTO>> moveProbes(PlateauTO plateauTO, ArrayList<ProbeTO> probeTOList ) {
		nasaServices.moveProbes(plateauTO, probeTOList);
		List<ProbeTO> probe = null;
		return new ResponseEntity<List<ProbeTO>>(probe, HttpStatus.CREATED);
	}

}
