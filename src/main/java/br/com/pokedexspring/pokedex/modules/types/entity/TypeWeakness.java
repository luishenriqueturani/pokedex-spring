package br.com.pokedexspring.pokedex.modules.types.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class TypeWeakness {

  private UUID id;

  private UUID typeRef;

  private UUID weak;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
