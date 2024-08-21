package br.com.pokedexspring.pokedex.modules.regions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "games")
@SQLDelete(sql = "UPDATE games SET deleted_at = now() WHERE id=?")
public class Games {

  public Games(long id, String name, String label, long regionId, long generationId) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.regionId = regionId;
    this.generationId = generationId;
  }

  public Games(long id, String name, String label, long regionId, Regions region, long generationId, Generations generation, String platform) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.regionId = regionId;
    this.region = region;
    this.generationId = generationId;
    this.generation = generation;
    this.platform = platform;
  }

  public Games(long id, String name, String label, Regions region, Generations generation) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.region = region;
    this.generation = generation;
  }

  public Games(long id, String name, String label, long regionId, long generationId, String platform) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.regionId = regionId;
    this.generationId = generationId;
    this.platform = platform;
  }

  public Games(long id, String name, String label, Regions region, Generations generation, String platform) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.region = region;
    this.generation = generation;
    this.platform = platform;
  }

  @Id
  private long id;

  @Column
  private String name;

  @Column
  private String label;

  @Column(name = "region_id")
  private long regionId;

  @OneToOne
  @JoinColumn(name = "region_id", insertable = false, updatable = false)
  private Regions region;

  @Column(name = "generation_id")
  private long generationId;

  @OneToOne
  @JoinColumn(name = "generation_id", insertable = false, updatable = false)
  private Generations generation;

  @Column
  private String platform;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
