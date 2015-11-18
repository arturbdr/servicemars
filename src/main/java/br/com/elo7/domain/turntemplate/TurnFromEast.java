package br.com.elo7.domain.turntemplate;

import br.com.elo7.domain.Direction;

public class TurnFromEast implements TurnTemplate {

	@Override
	public Direction turnLeft() {
		return Direction.NORTH;
	}

	@Override
	public Direction turnRight() {
		return Direction.SOUTH;
	}

}
