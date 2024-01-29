package br.com.pokedexspring.pokedex.modules.types.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PokemonImmunuty {

  private UUID id;

  private UUID pokemon;

  private UUID type;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
