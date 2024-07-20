package br.com.pokedexspring.pokedex.providers.pokeapi.evolutionchain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chain {
  private EvolutionDetails[] evolution_details;

  private Species species;

  private Chain[] evolves_to;
}
