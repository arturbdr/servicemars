package br.com.elo7.domain.movestrategy;

import br.com.elo7.domain.Direction;
import br.com.elo7.domain.Probe;
import br.com.elo7.domain.to.Coordinates;

public class ForwardAction implements IActionStrategy {

	private Probe probe;

	public ForwardAction (Probe probe) {
		this.probe = probe;
	}

	@Override
	public Probe moveAction() {
		String direction = probe.getDirection();
		Coordinates coordinates = probe.getCoordinates();
		Double longitude;
		Double latitude ;

		switch (Direction.getDirection(direction)) {
		case EAST:
			latitude = coordinates.getLatitude();
			latitude++;
			coordinates.setLatitude(latitude);
			break;

		case NORTH:
			longitude = coordinates.getLongitude();
			longitude++;
			coordinates.setLongitude(longitude);
			break;

		case SOUTH:
			longitude = coordinates.getLongitude();
			longitude--;
			coordinates.setLongitude(longitude);
			break;

		case WEST:
			latitude = coordinates.getLatitude();
			latitude--;
			coordinates.setLatitude(latitude);
			break;

		}

		probe.setCoordinates(coordinates);
		return this.probe;
	}
}