package br.com.pokedexspring.pokedex.modules.regions.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "regions")
public class Region {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private String name;

  private UUID generation;

  @CreationTimestamp
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
