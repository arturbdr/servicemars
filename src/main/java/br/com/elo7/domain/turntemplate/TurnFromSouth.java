package br.com.elo7.domain.turntemplate;

import br.com.elo7.domain.Direction;

public class TurnFromSouth implements TurnTemplate {

	@Override
	public Direction turnLeft() {
		return Direction.EAST;
	}

	@Override
	public Direction turnRight() {
		return Direction.WEST;
	}


}
