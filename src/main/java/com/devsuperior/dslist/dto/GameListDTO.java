package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}
	
	//Como nao usou o BeanUtils, pode implementar só os geters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
