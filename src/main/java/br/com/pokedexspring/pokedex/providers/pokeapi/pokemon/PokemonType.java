package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonType {

  private int slot;

  private Joker type;
}
