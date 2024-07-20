package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonMovesVersionGroupDetails {
  private int level_learned_at;

  private PokemonMovesVersionGroupDetailsMoveLearnMethod move_learn_method;
}
