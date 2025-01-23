package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable //indica que dois atributos do tipo id foram encapsulados nesta classe
public class BelongingPK {
	
	@ManyToOne //configurando tipo de relacionamento muitos pra um
	@JoinColumn(name = "game_id") //configurando para qual atributo da outra entidade a coluna fará referência
	private Game game;            //Ou seja: será um campo chave estrangeira
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	public BelongingPK() {
	}

	public BelongingPK(Game game, GameList list) {
		super();
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}

}
