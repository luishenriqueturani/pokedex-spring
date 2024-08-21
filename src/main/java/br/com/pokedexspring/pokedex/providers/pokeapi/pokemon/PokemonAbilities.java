package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonAbilities {
  private boolean is_hidden;
  private int slot;
  private Joker ability;
}
