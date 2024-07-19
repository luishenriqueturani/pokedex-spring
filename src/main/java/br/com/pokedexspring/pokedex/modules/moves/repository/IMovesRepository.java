package br.com.pokedexspring.pokedex.modules.moves.repository;

import br.com.pokedexspring.pokedex.modules.moves.entity.Moves;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IMovesRepository extends JpaRepository<Moves, UUID> {
}
