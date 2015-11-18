package br.com.elo7.domain.turntemplate;

import br.com.elo7.domain.Direction;

public class TurnFromWest implements TurnTemplate {

	@Override
	public Direction turnLeft() {
		return Direction.SOUTH;
	}

	@Override
	public Direction turnRight() {
		return Direction.NORTH;
	}


}
