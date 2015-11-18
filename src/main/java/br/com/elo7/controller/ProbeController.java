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

import br.com.elo7.domain.Plateau;
import br.com.elo7.domain.Probe;
import br.com.elo7.domain.to.Coordinates;
import br.com.elo7.domain.to.PlateauTO;
import br.com.elo7.domain.to.ProbeTO;
import br.com.elo7.services.NasaServices;

@RestController
@RequestMapping("nasaservices")
public class ProbeController {
	
	@Autowired
	private NasaServices nasaServices;
	
	/**
	 * Serviço responsável por criar um Planalto.
	 * Caso o planalto já tenha sido definido previamente, esse serviço retornará um erro.
	 * 
	 * <i>Esse serviço é utilitário.</i>
	 * @return Status informando se o serviço foi executado com sucesso (200) ou com erro (500) e respectivas informações do Plateau.
	 * 
	 */
	@RequestMapping(value = "/v1/plateau", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Plateau> createPlateau(PlateauTO plateauTO ) {
		Plateau plateau = nasaServices.createPlateau(plateauTO);
		return new ResponseEntity<Plateau>(plateau, HttpStatus.CREATED);
	}
	
	/**
	 * Servico responsável por criar um novo Probe em determinado Planalto
	 * 
	 * <i>Esse serviço é utilitário.</i>
	 * @return Status informando se o serviço foi executado com sucesso (200) ou com erro (500) e respectivas informações do Plateau.
	 * 
	 */
	@RequestMapping(value = "/v1/probe", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ProbeTO> createProbe(ProbeTO probeTO) {
		Probe probe = nasaServices.createProbe(probeTO);
		return new ResponseEntity<ProbeTO>(probe.getProbeTO(), HttpStatus.CREATED);
	}
	
	/**
	 * Serviço responsável por destruir (remover do planalto) uma Sonda
	 * 
	 * <i>Esse serviço é utilitário.</i>
	 * @return Um Status informando se o serviço foi executado com sucesso (200) ou com erros (500).
	 */
	@RequestMapping(value = "/v1/probe", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> destroyProbe(Long id, Coordinates coordinates) {
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	/**
	 * Serviço responsável por movimentar uma Sonda. Para localização da Sonda, utiliza seu ID.
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
	public ResponseEntity<ProbeTO> moveProbe(Long id, Coordinates coordinates) {
		ProbeTO probe = nasaServices.moveProbe(id, coordinates);
		return new ResponseEntity<ProbeTO>(probe, HttpStatus.CREATED);
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
	public ResponseEntity<List<ProbeTO>> moveProbes(Coordinates plateauCoordinates, ArrayList<ProbeTO> probeTOList ) {
		List<ProbeTO> probe = nasaServices.moveProbes(plateauCoordinates, probeTOList);
		return new ResponseEntity<List<ProbeTO>>(probe, HttpStatus.CREATED);
	}

}
