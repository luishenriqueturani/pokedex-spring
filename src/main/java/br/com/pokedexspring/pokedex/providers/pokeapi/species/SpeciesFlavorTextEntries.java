package br.com.pokedexspring.pokedex.providers.pokeapi.species;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpeciesFlavorTextEntries {
  private String flavor_text;

  private SpeciesFlavorTextEntriesLanguage language;

  private SpeciesFlavorTextEntriesVersion version;

  private SpeciesGeneration generation;


}
