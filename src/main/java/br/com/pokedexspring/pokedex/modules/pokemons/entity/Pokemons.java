package br.com.pokedexspring.pokedex.modules.pokemons.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Pokemons {

  private UUID id;

  private int number;

  private String name;

  private UUID type1;

  private UUID type2;

  private UUID generation;

  private UUID evolveTo;

  private UUID preEvolution;

  private float height;

  private float weight;

  private String category;

  private Integer evolveLevel;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
