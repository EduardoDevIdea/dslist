package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // registra a classe como um componente do sistema
public class GameService {
	
	@Autowired//Injetando um GameRepository no GameService
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) //Para garantir os principios ACID. readOnly = true para assegurar que não haverá escrita no banco de dados
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get(); //fybndById retorna um Optional. Pra pegar o Game que tá dentro do Optional tem que usar o .get
		                                                 // Seria bom fazer um tratamento de excessão para caso o Id não exista, mas não foi feito para agilizar tempo de aula
		 return new GameDTO(result); //convertento o game foi buscado do banco de dados e convertendo em GameDTO e retornando o GameDTO
	}
	
	@Transactional(readOnly = true)
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
