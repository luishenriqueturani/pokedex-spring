package br.com.pokedexspring.pokedex.providers.pokeapi.evolutionchain;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Chain {
  private List<EvolutionDetails> evolution_details;

  private Joker species;

  private List<Chain> evolves_to;
}
