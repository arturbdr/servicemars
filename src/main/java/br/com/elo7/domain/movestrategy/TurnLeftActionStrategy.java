package br.com.elo7.domain.movestrategy;

import br.com.elo7.domain.Direction;
import br.com.elo7.domain.Probe;

public class TurnLeftActionStrategy implements IActionStrategy {
	
	private Probe probe;

	public TurnLeftActionStrategy (Probe probe) {
		this.probe = probe;
	}

	@Override
	public Probe moveAction() {
		
		String direction = probe.getDirection();

		switch (Direction.getDirection(direction)) {
		case EAST:
			probe.setDirection(Direction.NORTH.getValue());
			break;

		case NORTH:
			probe.setDirection(Direction.WEST.getValue());
			break;

		case SOUTH:
			probe.setDirection(Direction.EAST.getValue());
			break;

		case WEST:
			probe.setDirection(Direction.SOUTH.getValue());
			break;

		}
		
		return probe;
	}

}
