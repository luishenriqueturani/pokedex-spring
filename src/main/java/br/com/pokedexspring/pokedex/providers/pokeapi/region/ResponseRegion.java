package br.com.pokedexspring.pokedex.providers.pokeapi.region;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseRegion {
  private int id;
  private String name;
  private List<Joker> version_groups;
}
