package br.com.elo7.domain.movestrategy;

import br.com.elo7.domain.Direction;
import br.com.elo7.domain.Probe;

public class TurnRightActionStrategy implements IActionStrategy{
	
	private Probe probe;

	public TurnRightActionStrategy (Probe probe) {
		this.probe = probe;
	}

	@Override
	public Probe moveAction() {
		
		String direction = probe.getDirection();

		switch (Direction.getDirection(direction)) {
		case EAST:
			probe.setDirection(Direction.SOUTH.getValue());
			break;

		case NORTH:
			probe.setDirection(Direction.EAST.getValue());
			break;

		case SOUTH:
			probe.setDirection(Direction.WEST.getValue());
			break;

		case WEST:
			probe.setDirection(Direction.NORTH.getValue());
			break;

		}
		
		return probe;
	}
}
