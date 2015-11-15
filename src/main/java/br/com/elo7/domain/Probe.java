package br.com.elo7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.elo7.domain.movestrategy.ForwardAction;
import br.com.elo7.domain.movestrategy.IActionStrategy;
import br.com.elo7.domain.movestrategy.TurnLeftActionStrategy;
import br.com.elo7.domain.movestrategy.TurnRightActionStrategy;
import br.com.elo7.domain.repository.ProbeRepository;
import br.com.elo7.domain.to.Coordinates;
import br.com.elo7.domain.to.ProbeTO;

@Entity
@Table(name="PROBE")
public class Probe {

	private ProbeTO probeTO;
	private Plateau plateau;
	
	@Transient
	public Coordinates getCoordinates() {
		return this.probeTO.getCoordinates();
	}
	
	@Column(name="DIRECTION")
	public String getDirection() {
		Direction direction = this.probeTO.getDirection();
		return direction != null ? direction.getValue() : null;
	}

	@Id
	@Column(name="ID_PROBE")
	public Long getId() {
		return this.probeTO.getId();
	}
	
	@Column(name="LATITUDE")
	public Double getLatitude() {
		Coordinates coordinates = this.probeTO.getCoordinates();
		return coordinates != null ? coordinates.getLatitude() : 0;
	}
	
	@Column(name="LONGITUDE")
	public Double getLongitude() {
		Coordinates coordinates = this.probeTO.getCoordinates();
		return coordinates != null ? coordinates.getLongitude() : 0;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PLATEAU")
	public Plateau getPlateau() {
		return plateau;
	}
	
	public Probe move(String command) {
		IActionStrategy actionStrategy = null;
		if (Command.getCommand(command).equals(Command.MOVE)) {
			actionStrategy = new ForwardAction(this);
		}
		else if (Command.getCommand(command).equals(Command.LEFT)) {
			actionStrategy = new TurnLeftActionStrategy(this);
		}
		else if (Command.getCommand(command).equals(Command.RIGHT)) {
			actionStrategy = new TurnRightActionStrategy(this);
			
		}
		
		return actionStrategy.moveAction();
	}
	
	public Probe save(final ProbeRepository repository) {
		return repository.save(this);
	}
	
	public void setCoordinates(final Coordinates coordinates) {
		this.probeTO.setCoordinates(coordinates);
	}
	
	public void setDirection(String direction) {
		this.probeTO.setDirection(Direction.getDirection(direction));
	}
	
	public void setId(final Long id) {
		this.probeTO.setId(id);
	}
	
	public void setLatitude(Double latitude) {
		Coordinates coordinates = this.probeTO.getCoordinates();
		
		if(coordinates == null) {
			coordinates = new Coordinates();
		}
		coordinates.setLatitude(latitude);
		this.probeTO.setCoordinates(coordinates);
	}

	public void setLongitude(Double longitude) {
		Coordinates coordinates = this.probeTO.getCoordinates();
		
		if(coordinates == null) {
			coordinates = new Coordinates();
		}
		coordinates.setLongitude(longitude);
		this.probeTO.setCoordinates(coordinates);
	}
	
}
