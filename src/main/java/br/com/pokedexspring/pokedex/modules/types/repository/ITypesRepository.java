package br.com.pokedexspring.pokedex.modules.types.repository;

import br.com.pokedexspring.pokedex.modules.types.entity.Types;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITypesRepository extends JpaRepository<Types, UUID> {
}
