package br.com.pokedexspring.pokedex.providers.pokeapi.region;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseRegions {
  private int count;
  private Joker[] results;
}
