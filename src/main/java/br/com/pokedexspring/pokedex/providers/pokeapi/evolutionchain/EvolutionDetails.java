package br.com.pokedexspring.pokedex.providers.pokeapi.evolutionchain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EvolutionDetails {

  private Joker gender;
  private Joker held_item;
  private Joker item;
  private Joker known_move;
  private Joker known_move_type;
  private Joker location;
  private Joker min_affection;
  private Joker min_beauty;
  private Joker min_happiness;
  private Joker min_level;
  private Joker needs_overworld_rain;
  private Joker party_species;
  private Joker party_type;
  private Joker relative_physical_stats;
  private Joker time_of_day;
  private Joker trade_species;
  private Trigger trigger;
  private Joker turn_upside_down;


}

