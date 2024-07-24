package br.com.pokedexspring.pokedex.service;

import br.com.pokedexspring.pokedex.modules.regions.entity.Games;
import br.com.pokedexspring.pokedex.modules.regions.entity.Generations;
import br.com.pokedexspring.pokedex.modules.regions.entity.Regions;
import br.com.pokedexspring.pokedex.modules.regions.repository.IGamesRepository;
import br.com.pokedexspring.pokedex.modules.regions.repository.IGenerationRepository;
import br.com.pokedexspring.pokedex.modules.regions.repository.IRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Services {

  @Autowired
  private IRegionRepository regionRepository;
  @Autowired
  private IGamesRepository gamesRepository;
  @Autowired
  private IGenerationRepository generationRepository;


  public Regions saveRegion(Regions region){
    return this.regionRepository.save(region);
  }

  public Generations saveGeneration(Generations generation){
    return this.generationRepository.save(generation);
  }

  public Games saveGames(Games game){
    return this.gamesRepository.save(game);
  }

  public Games getGamesByLabel(String label){
    return this.gamesRepository.findOneByLabel(label);
  }

}
