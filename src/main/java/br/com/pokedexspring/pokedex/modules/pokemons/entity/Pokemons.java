package br.com.pokedexspring.pokedex.modules.pokemons.entity;

import br.com.pokedexspring.pokedex.modules.regions.entity.Generations;
import br.com.pokedexspring.pokedex.modules.types.entity.Types;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pokemons")
@SQLDelete(sql = "UPDATE pokemons SET deleted_at = now() WHERE id=?")
public class Pokemons {

  public Pokemons(long id, int number, String name, String label, long type1Id, Types type1, long type2Id, Types type2, long generationId, Generations generation, long evolveToId, List<Pokemons> evolveTo, long preEvolutionId, Pokemons preEvolution, float height, float weight, String category, Integer evolveLevel) {
    this.id = id;
    this.number = number;
    this.name = name;
    this.label = label;
    this.type1Id = type1Id;
    this.type1 = type1;
    this.type2Id = type2Id;
    this.type2 = type2;
    this.generationId = generationId;
    this.generation = generation;
    this.evolveToId = evolveToId;
    this.evolveTo = evolveTo;
    this.preEvolutionId = preEvolutionId;
    this.preEvolution = preEvolution;
    this.height = height;
    this.weight = weight;
    this.category = category;
    this.evolveLevel = evolveLevel;
  }

  public Pokemons(long id, int number, String name, String label, long type1Id, long type2Id, long generationId, long evolveToId, long preEvolutionId, float height, float weight, String category, Integer evolveLevel) {
    this.id = id;
    this.number = number;
    this.name = name;
    this.label = label;
    this.type1Id = type1Id;
    this.type2Id = type2Id;
    this.generationId = generationId;
    this.evolveToId = evolveToId;
    this.preEvolutionId = preEvolutionId;
    this.height = height;
    this.weight = weight;
    this.category = category;
    this.evolveLevel = evolveLevel;
  }

  public Pokemons(long id, int number, String name, String label, Types type1, Types type2, Generations generation, List<Pokemons> evolveTo, Pokemons preEvolution, float height, float weight, String category, Integer evolveLevel) {
    this.id = id;
    this.number = number;
    this.name = name;
    this.label = label;
    this.type1 = type1;
    this.type2 = type2;
    this.generation = generation;
    this.evolveTo = evolveTo;
    this.preEvolution = preEvolution;
    this.height = height;
    this.weight = weight;
    this.category = category;
    this.evolveLevel = evolveLevel;
  }

  @Id
  private long id;

  @Column(unique = true)
  private int number;

  @Column
  private String name;

  @Column
  private String label;

  @Column(name = "type1")
  private long type1Id;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type1", insertable = false, updatable = false)
  private Types type1;

  @Column(name = "type2")
  private long type2Id;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type2", insertable = false, updatable = false)
  private Types type2;

  @Column(name = "generation_id")
  private long generationId;

  @OneToOne(targetEntity = Generations.class)
  @JoinColumn(name = "generation_id", insertable = false, updatable = false)
  private Generations generation;

  @Column(name = "evolve_to")
  private long evolveToId;

  @OneToMany(targetEntity = Pokemons.class)
  @JoinColumn(name = "evolve_to", insertable = false, updatable = false)
  private List<Pokemons> evolveTo;

  @Column(name = "pre_evolution")
  private long preEvolutionId;

  @OneToOne(targetEntity = Pokemons.class)
  @JoinColumn(name = "pre_evolution", insertable = false, updatable = false)
  private Pokemons preEvolution;

  @Column
  private float height;

  @Column
  private float weight;

  @Column
  private String category;

  @Column(name = "evolve_level")
  private Integer evolveLevel;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
