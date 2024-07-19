package br.com.pokedexspring.pokedex.modules.regions.repository;

import br.com.pokedexspring.pokedex.modules.regions.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IGamesRepository extends JpaRepository<Games, UUID> {
}
