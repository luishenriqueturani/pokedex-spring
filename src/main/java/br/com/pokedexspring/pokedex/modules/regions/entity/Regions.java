package br.com.pokedexspring.pokedex.modules.regions.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "regions")
@SQLDelete(sql = "UPDATE regions SET deleted_at = now() WHERE id=?")
public class Regions {

  public Regions(String name, String label){
    this.name = name;
    this.label = label;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  @Column
  private String name;

  @Column
  private String label;

  @Column(name = "generation_id")
  private UUID generationId;

  @OneToMany
  @JoinColumn(name = "generation_id", insertable = false, updatable = false)
  private List<Generations> generations;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
