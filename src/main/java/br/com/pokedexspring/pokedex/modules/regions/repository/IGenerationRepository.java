package br.com.pokedexspring.pokedex.modules.regions.repository;

import br.com.pokedexspring.pokedex.modules.regions.entity.Generations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IGenerationRepository extends JpaRepository<Generations, UUID> {
}
