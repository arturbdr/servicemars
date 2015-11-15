package br.com.elo7.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo7.domain.Probe;
import br.com.elo7.domain.repository.ProbeRepository;
import br.com.elo7.domain.to.PlateauTO;
import br.com.elo7.domain.to.ProbeTO;

/**
 * Classe contendo os servicos responsaveis pela criacao de um planalto (definicao do espaco em que uma sonda pode se mover)
 * e respectiva movimentacao das Sondas nesse planalto
 * 
 */
@Service
public class NasaServices {
	
	@Autowired
	private ProbeRepository probeRepository;

	public List<ProbeTO> moveProbes(PlateauTO plateauTO, List<ProbeTO> probeTOList) {
		return null;
	}
	
	@Transactional
	public Probe findExplorer(int id) {
		Probe probe = probeRepository.find(id);
		return probe;
	}
	
	

	
}
