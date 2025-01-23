package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service // registra a classe como um componente do sistema
public class GameListService {
	
	@Autowired//Injetando um GameRepository no GameService
	private GameListRepository gameListRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList(); 
		   //stream é uma lib do java que permite fazero operações com sequencia de dados. O map transforma de "uma coisa pra outra" 
		   //(x -> new GameMinDTO(x)) todoobjeto x original que era GameList transforma ele em um GameListDTO passando o propprio x como argumento
		   //.toList() transforma em lista
		   // a lista de GameList foi transformada em uma lista de GameListDTO

	}

}