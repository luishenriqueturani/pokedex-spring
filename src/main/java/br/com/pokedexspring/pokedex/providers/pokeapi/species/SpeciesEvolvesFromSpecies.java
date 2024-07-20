package br.com.pokedexspring.pokedex.providers.pokeapi.species;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpeciesEvolvesFromSpecies {
  private String name;
  private String url;
}
