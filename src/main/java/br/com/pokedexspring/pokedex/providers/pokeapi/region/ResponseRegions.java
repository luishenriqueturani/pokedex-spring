package br.com.pokedexspring.pokedex.providers.pokeapi.region;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseRegions {
  private int count;
  private List<Joker> results;
}
