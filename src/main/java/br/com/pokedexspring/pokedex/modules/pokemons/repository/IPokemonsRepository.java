package br.com.pokedexspring.pokedex.modules.pokemons.repository;

import br.com.pokedexspring.pokedex.modules.pokemons.entity.Pokemons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPokemonsRepository extends JpaRepository<Pokemons, UUID> {
}
