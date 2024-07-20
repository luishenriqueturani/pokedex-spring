package br.com.pokedexspring.pokedex.providers.pokeapi.evolutionchain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trigger {
  private String name;
  private String url;

}
