package br.com.pokedexspring.pokedex.modules.types.repository;

import br.com.pokedexspring.pokedex.modules.types.entity.TypeWeakness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITypeWeaknessRepository extends JpaRepository<TypeWeakness, UUID> {
}
