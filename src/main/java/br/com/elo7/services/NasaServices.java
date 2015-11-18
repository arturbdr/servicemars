package br.com.elo7.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo7.domain.Plateau;
import br.com.elo7.domain.Probe;
import br.com.elo7.domain.repository.PlateauRepository;
import br.com.elo7.domain.repository.ProbeRepository;
import br.com.elo7.domain.to.Coordinates;
import br.com.elo7.domain.to.PlateauTO;
import br.com.elo7.domain.to.ProbeTO;

/**
 * Classe contendo os servicos responsaveis pela criacao de um planalto (definicao do espaco em que uma sonda pode se mover)
 * e respectiva movimentacao das Sondas nesse planalto.
 */
@Service
public class NasaServices {
	
	@Autowired
	private ProbeRepository probeRepository;
	
	@Autowired
	private PlateauRepository plateauRepository;

	@Transactional
	public List<ProbeTO> moveProbes(Coordinates plateauCoordinates, List<ProbeTO> probeTOList) {
		Plateau plateau = plateauRepository.findByCoordinates(plateauCoordinates);
		
		if (plateau == null){
			Plateau createPlateauWithCoordinates = createPlateauWithCoordinates(plateauCoordinates);
		}
		// TODO finish
		return null;
	}
	
	public Probe findExplorer(Long id) {
		Probe probe = probeRepository.find(id);
		return probe;
	}
	
	@Transactional
	public void destroyProbe(Long id, Coordinates coordinates) {
		Probe probe = probeRepository.find(id); 
		if (probe == null) {
			probe = probeRepository.findByCoordinates(coordinates); 
		}
		// TODO finish
		probeRepository.delete(probe);
	}

	@Transactional
	public ProbeTO moveProbe(Long id, Coordinates coordinates) {
		// TODO finish
		return null;
	}

	@Transactional
	public Plateau createPlateau(PlateauTO plateauTO) {
		return new Plateau(plateauTO).save(plateauRepository);
	}
	
	@Transactional
	public Plateau createPlateauWithCoordinates(Coordinates plateauCoordinates) {
		return new Plateau(plateauCoordinates).save(plateauRepository);
	}

	@Transactional
	public Probe createProbe(ProbeTO probeTO) {
		return new Probe(probeTO).save(probeRepository);
	}
}
