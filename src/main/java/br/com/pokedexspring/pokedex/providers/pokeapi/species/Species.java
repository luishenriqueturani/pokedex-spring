package br.com.pokedexspring.pokedex.providers.pokeapi.species;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Species {

  private Joker evolves_from_species;

  private List<SpeciesFlavorTextEntries> flavor_text_entries;

  private SpeciesEvolutionChain evolution_chain;
}
