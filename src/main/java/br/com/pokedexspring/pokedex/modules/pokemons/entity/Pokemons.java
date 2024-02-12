package br.com.pokedexspring.pokedex.modules.pokemons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE pokemons SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Pokemons {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(unique = true)
  private int number;

  @Column
  private String name;

  @Column
  private UUID type1;

  @Column
  private UUID type2;

  @Column
  private UUID generation;

  @Column
  private UUID evolveTo;

  @Column
  private UUID preEvolution;

  @Column
  private float height;

  @Column
  private float weight;

  @Column
  private String category;

  @Column
  private Integer evolveLevel;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
