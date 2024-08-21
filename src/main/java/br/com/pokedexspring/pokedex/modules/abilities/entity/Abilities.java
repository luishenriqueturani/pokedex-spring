package br.com.pokedexspring.pokedex.modules.abilities.entity;

import br.com.pokedexspring.pokedex.modules.regions.entity.Generations;
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
@Entity(name = "abilities")
@SQLDelete(sql = "UPDATE abilities SET deleted_at = now() WHERE id=?")
public class Abilities {

  public Abilities(long id, String name, String label, String description, long generation, List<Generations> generations) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.description = description;
    this.generation = generation;
    this.generations = generations;
  }

  public Abilities(long id, String name, String label, String description, long generation) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.description = description;
    this.generation = generation;
  }

  public Abilities(long id, String name, String label, String description, List<Generations> generations) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.description = description;
    this.generations = generations;
  }

  @Id
  private long id;

  @Column
  private String name;

  @Column
  private String label;

  @Column
  private String description;

  @Column(name = "generation_id")
  private long generation;

  @OneToMany(targetEntity = Generations.class)
  @JoinColumn(name = "generation_id", insertable = false, updatable = false)
  private List<Generations> generations;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
