package br.com.pokedexspring.pokedex.modules.types.repository;

import br.com.pokedexspring.pokedex.modules.types.entity.TypeAdvantages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITypeAdvantagesRepository extends JpaRepository<TypeAdvantages, UUID> {
}
