package br.com.pokedexspring.pokedex.modules.regions.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "regions")
@SQLDelete(sql = "UPDATE regions SET deleted_at = now() WHERE id=?")
public class Regions {

  public Regions(long id, String name, String label){
    this.id = id;
    this.name = name;
    this.label = label;
  }

  public Regions(long id, String name, String label, long generationId, List<Generations> generations) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.generationId = generationId;
    this.generations = generations;
  }

  public Regions(long id, String name, String label, List<Generations> generations) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.generations = generations;
  }

  public Regions(long id, String name, String label, long generationId) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.generationId = generationId;
  }

  @Id
  private long id;

  @Column
  private String name;

  @Column
  private String label;

  @Column(name = "generation_id")
  private long generationId;

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
