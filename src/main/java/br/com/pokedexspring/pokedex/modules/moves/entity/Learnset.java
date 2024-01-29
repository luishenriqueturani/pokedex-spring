package br.com.pokedexspring.pokedex.modules.moves.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Learnset {

  private UUID id;

  private UUID pokemon;

  private UUID move;

  private Integer power;

  private Integer accuracy;

  private Integer pp;

  private String description;

  private UUID game;

  private String learnMethod;

  private String joker;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
