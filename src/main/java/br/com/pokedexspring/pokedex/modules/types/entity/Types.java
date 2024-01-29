package br.com.pokedexspring.pokedex.modules.types.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Types {

  private UUID id;

  private String label;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
