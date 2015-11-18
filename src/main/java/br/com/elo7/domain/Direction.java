package br.com.elo7.domain;

public enum Direction {
	
	EAST("E", "East"),
	NORTH("N", "North"),
	SOUTH("S", "South"),
	WEST("W", "West");

	private String value;
	private String description; 

	private Direction(String value, String description) {
		this.value = value;
		this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	
	/**
	 * Com base em uma String, retorna a descrição da direção
	 * @param value - Um dos valores possiveis do Enum
	 * @return Uma String contendo a descrição da direção ou null, caso não exista valores
	 */
	public static String getDirectionDescription(String value) {
		for(Direction direction : values()) {
			if(direction.value.equals(value))
				return direction.description;
		}
		return null;
	}
	
	/**
	 * Com base em uma String, retorna o respectivo Enum
	 * @param value - Um dos valores possiveis do Enum
	 * @return Uma String contendo a descrição da direção ou null, caso não exista valores
	 */
	public static Direction getDirection(String value) {
		for(Direction direction : values()) {
			if(direction.value.equals(value))
				return direction;
		}
		return null;
	}
	

}
