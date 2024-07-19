package br.com.pokedexspring.pokedex.modules.types.repository;

import br.com.pokedexspring.pokedex.modules.types.entity.PokemonResistances;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPokemonResistancesRepository extends JpaRepository<PokemonResistances, UUID> {
}
