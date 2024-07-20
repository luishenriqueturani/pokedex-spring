package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pokemon {
  private float height;

  private String name;

  private float weight;

  private PokemonType[] types;

  private PokemonSpecies species;

  private PokemonAbilities[] abilities;

  private PokemonMoves[] moves;
}
