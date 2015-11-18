package br.com.elo7.domain.turntemplate;

import br.com.elo7.domain.Direction;

public class TurnFactory {
	
	public static TurnTemplate getTurnDirection(Direction direction) {
		
		switch (direction) {
		case EAST:
			return new TurnFromEast();
		case NORTH:
			return new TurnFromNorth();
		case SOUTH:
			return new TurnFromSouth();
		case WEST:
			return new TurnFromWest();
		}
		return null;
	}

}
