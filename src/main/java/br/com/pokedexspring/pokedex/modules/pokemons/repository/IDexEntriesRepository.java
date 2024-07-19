package br.com.pokedexspring.pokedex.modules.pokemons.repository;

import br.com.pokedexspring.pokedex.modules.pokemons.entity.DexEntries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDexEntriesRepository extends JpaRepository<DexEntries, UUID> {
}
