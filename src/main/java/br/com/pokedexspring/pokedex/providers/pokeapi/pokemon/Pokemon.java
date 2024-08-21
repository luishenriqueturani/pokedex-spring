package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pokemon {
  private float height;

  private String name;

  private float weight;

  private List<PokemonType> types;

  private Joker species;

  private List<PokemonAbilities> abilities;

  private List<PokemonMoves> moves;
}
