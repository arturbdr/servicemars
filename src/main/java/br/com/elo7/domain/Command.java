package br.com.elo7.domain;

public enum Command {
	
	LEFT("L", "Left"), 
	MOVE("M", "Move"),
	RIGHT("R", "Right");

	private String value;
	private String description;

	private Command(String value, String description) {
		this.value = value;
		this.description = description;
	}
	
	/**
	 * Com base em uma String, retorna a descrição da direção
	 * @param value - Um dos valores possiveis do Enum
	 * @return Uma String contendo a descrição da direção ou null, caso não exista valores
	 */
	public static String getCommandDescription(String value) {
		for(Command command : values()) {
			if(command.value.equals(value))
				return command.description;
		}
		return null;
	}
	
	/**
	 * Com base em uma String, retorna o respectivo Enum
	 * @param value - Um dos valores possiveis do Enum
	 * @return Uma String contendo a descrição da direção ou null, caso não exista valores
	 */
	public static Command getCommand(String value) {
		for(Command command : values()) {
			if(command.value.equals(value))
				return command;
		}
		return null;
	}
	
}
