package br.com.elo7.domain.turntemplate;

import br.com.elo7.domain.Direction;

public class TurnFromNorth implements TurnTemplate {

	@Override
	public Direction turnLeft() {
		return Direction.WEST;
	}

	@Override
	public Direction turnRight() {
		return Direction.EAST;
	}


}
