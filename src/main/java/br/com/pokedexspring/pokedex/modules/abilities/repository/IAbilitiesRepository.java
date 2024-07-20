package br.com.pokedexspring.pokedex.modules.abilities.repository;

import br.com.pokedexspring.pokedex.modules.abilities.entity.Abilities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IAbilitiesRepository extends JpaRepository<Abilities, UUID> {
  List<Abilities> findByDeletedAtIsNull();
}
