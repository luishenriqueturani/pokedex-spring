package br.com.pokedexspring.pokedex.providers.pokeapi.species;

import br.com.pokedexspring.pokedex.providers.pokeapi.Joker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpeciesFlavorTextEntries {
  private String flavor_text;

  private SpeciesFlavorTextEntriesLanguage language;

  private Joker version;

  private Joker generation;


}
