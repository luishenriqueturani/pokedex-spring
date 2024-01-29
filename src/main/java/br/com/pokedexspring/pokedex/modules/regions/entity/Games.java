package br.com.pokedexspring.pokedex.modules.regions.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Games {

  private UUID id;

  private String name;

  private UUID region;

  private UUID generation;

  private String platform;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
