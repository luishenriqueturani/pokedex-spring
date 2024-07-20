package br.com.pokedexspring.pokedex.providers.pokeapi.species;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Species {

  private SpeciesEvolvesFromSpecies evolves_from_species;

  private SpeciesFlavorTextEntries[] flavor_text_entries;

  private SpeciesEvolutionChain evolution_chain;
}
