package br.com.pokedexspring.pokedex.modules.regions.repository;

import br.com.pokedexspring.pokedex.modules.regions.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IRegionRepository extends JpaRepository<Region, UUID> {

  List<Region> findAll();

  List<Region> findByRegionId(UUID id);


}
