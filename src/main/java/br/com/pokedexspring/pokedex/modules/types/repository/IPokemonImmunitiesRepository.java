package br.com.pokedexspring.pokedex.modules.types.repository;

import br.com.pokedexspring.pokedex.modules.types.entity.PokemonImmunities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPokemonImmunitiesRepository extends JpaRepository<PokemonImmunities, UUID> {
}
