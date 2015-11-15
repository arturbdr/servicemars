package br.com.elo7.domain.to;

/**
 * Classe de transporte para representação de uma Sonda. 
 * Possui estrutura básica apenas para comunicação (nesse cenário, entrada dos serviços).
 */
public class PlateauTO {

	private Coordinates coordinates;
	private Long id;
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
}
