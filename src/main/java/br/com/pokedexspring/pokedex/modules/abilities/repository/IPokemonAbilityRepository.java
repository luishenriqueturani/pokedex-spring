package br.com.pokedexspring.pokedex.modules.abilities.repository;

import br.com.pokedexspring.pokedex.modules.abilities.entity.PokemonAbility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPokemonAbilityRepository extends JpaRepository<PokemonAbility, UUID> {
}
