package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {

	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
	
	//List<GameMinProjection> searchByList(Long listId); para consultas customizadas no jpa
	/*
	 *  escreve o método colocando no parâmetroo que vai precisar para a consulta, nesse caso querbuscar pelo id e deu o nome de listId
	 *  :listId na consulta usando dois pontos e colocando o mesmo nome do parãmetro passado no método fará com que a consulta receba o valor passado
	 */
	
	/* OBS
	 * Quando usa nativeQuery o resultado da consulta tem que ser uma interface (no Spring é chamada de Projection)
	 * Então a interface GameMinProjection foi criada e nela terá métodos get correspondentes à consulta
	 * Os métodos (Sem implementação, pois é uma interface) terão o mesmo tipo das propriedades da entidade
	 */
}



