package br.com.pokedexspring.pokedex.modules.moves.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Move {

  private UUID id;

  private String name;

  private UUID type;

  private String category;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;

}
