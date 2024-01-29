package br.com.pokedexspring.pokedex.modules.abilities.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Abilities {

  private UUID id;

  private String name;

  private String description;

  private UUID generation;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
