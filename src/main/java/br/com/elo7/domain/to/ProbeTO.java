package br.com.elo7.domain.to;

import br.com.elo7.domain.Direction;

/**
 * Classe de transporte para representação de uma Sonda. 
 * Possui estrutura básica apenas para comunicação (nesse cenário, entrada/saíde de serviços).
 */
public class ProbeTO {
	
	private Coordinates coordinates;
	private Direction direction;
	private Long id;
	private PlateauTO plateauTO;
	
	
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public Direction getDirection() {
		return direction;
	}

	public Long getId() {
		return id;
	}

	public PlateauTO getPlateauTO() {
		return plateauTO;
	}

	public void setPlateauTO(PlateauTO plateauTO) {
		this.plateauTO = plateauTO;
	} 

}
