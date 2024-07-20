package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonMoves {
  private PokemonMovesMove move;

  private PokemonMovesVersionGroupDetails[] version_group_details;

}
