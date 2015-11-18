package br.com.elo7.domain.movestrategy;

import br.com.elo7.domain.Direction;
import br.com.elo7.domain.Probe;
import br.com.elo7.domain.turntemplate.TurnFactory;

public class TurnLeftActionStrategy implements IActionStrategy {
	
	private Probe probe;

	public TurnLeftActionStrategy (Probe probe) {
		this.probe = probe;
	}

	@Override
	public Probe moveAction() {
		
		
		String currentDirection = probe.getDirection();
		Direction directionAfterTurn = TurnFactory.getTurnDirection(Direction.getDirection(currentDirection)).turnLeft();
		probe.setDirection(directionAfterTurn.getValue());
		
		return probe;
		
	}

}
