package br.com.pokedexspring.pokedex.modules.moves.repository;

import br.com.pokedexspring.pokedex.modules.moves.entity.Learnset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ILearnsetRepository extends JpaRepository<Learnset, UUID> {
}
