package br.com.pokedexspring.pokedex.modules.abilities.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PokemonAbility {

  private UUID id;

  private UUID pokemon;

  private UUID ability;

  private String abilityType;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
