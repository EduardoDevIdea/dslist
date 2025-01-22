package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // registra a classe como um componente do sistema
public class GameService {
	
	@Autowired//Injetando um GameRepository no GameService
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); 
		   //stream éuma lib do java que permite fazero operações com sequencia de dados. O map transforma de "uma coisa pra outra" 
		   //(x -> new GameMinDTO(x)) todoobjeto x original que era Game transforma ele em um GameminDTO passando o propprio x como argumento
		   //.toList() transforma em lista
		   // a lista de games foi transformada em uma lista de gamesminDTO
		return dto;
	}

}
