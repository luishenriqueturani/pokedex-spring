package br.com.pokedexspring.pokedex.modules.regions.repository;

import br.com.pokedexspring.pokedex.modules.regions.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRegionRepository extends JpaRepository<Regions, UUID> {

  List<Regions> findAll();

  Optional<Regions> findById(UUID id);


}
