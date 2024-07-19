package br.com.pokedexspring.pokedex.modules.types.repository;

import br.com.pokedexspring.pokedex.modules.types.entity.PokemonWeakness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPokemonWeaknessRepository extends JpaRepository<PokemonWeakness, UUID> {
}
