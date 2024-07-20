package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonType {

  private int slot;

  private PokemonTypeType type;
}
