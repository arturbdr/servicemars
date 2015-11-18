package br.com.elo7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.elo7.domain.repository.PlateauRepository;
import br.com.elo7.domain.to.Coordinates;
import br.com.elo7.domain.to.PlateauTO;

@Entity
@Table(name="PLATEAU")
public class Plateau {

	private Long id;
	private PlateauTO plateauTO;

	public Plateau() {}
	
	public Plateau(Coordinates coordinates) {
		PlateauTO plateauTO = new PlateauTO();
		plateauTO.setCoordinates(coordinates);
	}

	public Plateau(PlateauTO plateauTO) {
		this.plateauTO = plateauTO;
	}

	@Id
	@GeneratedValue
	@Column(name="ID_PLATEAU")
	public Long getId() {
		return id;
	}

	@Column(name="LATITUDE")
	public Double getLatitude() {
		Coordinates coordinates = plateauTO.getCoordinates();
		return coordinates != null ? coordinates.getLatitude() : 0;
	}

	@Column(name="LONGITUDE")
	public Double getLongitude() {
		Coordinates coordinates = plateauTO.getCoordinates();
		return coordinates != null ? coordinates.getLongitude() : 0;
	}

	public Plateau save(PlateauRepository repository) {
		return repository.save(this);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLatitude(Double latitude) {
		Coordinates coordinates = this.plateauTO.getCoordinates();

		if(coordinates == null) {
			coordinates = new Coordinates();
		}
		coordinates.setLatitude(latitude);
		this.plateauTO.setCoordinates(coordinates);
	}

	public void setLongitude(Double longitude) {
		Coordinates coordinates = this.plateauTO.getCoordinates();

		if(coordinates == null) {
			coordinates = new Coordinates();
		}
		coordinates.setLongitude(longitude);
		this.plateauTO.setCoordinates(coordinates);
	}
	
	@Transient
	public PlateauTO getPlateauTO() {
		return this.plateauTO;
	}
	
}
