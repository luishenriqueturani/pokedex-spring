package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonMovesVersionGroupDetails {
  private int level_learned_at;

  private Joker move_learn_method;
}
