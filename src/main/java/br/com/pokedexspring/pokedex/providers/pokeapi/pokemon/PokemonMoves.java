package br.com.pokedexspring.pokedex.providers.pokeapi.pokemon;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PokemonMoves {
  private Joker move;

  private List<PokemonMovesVersionGroupDetails> version_group_details;

}
