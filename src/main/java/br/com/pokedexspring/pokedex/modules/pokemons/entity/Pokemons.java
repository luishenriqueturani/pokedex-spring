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
@Entity
@SQLDelete(sql = "UPDATE pokemons SET deleted_at = now() WHERE id=?")
public class Pokemons {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(unique = true)
  private int number;

  @Column
  private String name;

  @Column(name = "type1")
  private UUID type1Id;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type1", insertable = false, updatable = false)
  private Types type1;

  @Column(name = "type2")
  private UUID type2Id;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type2", insertable = false, updatable = false)
  private Types type2;

  @Column(name = "generation_id")
  private UUID generationId;

  @OneToOne(targetEntity = Generations.class)
  @JoinColumn(name = "generation_id", insertable = false, updatable = false)
  private Generations generation;

  @Column(name = "evolve_to")
  private UUID evolveToId;

  @OneToMany(targetEntity = Pokemons.class)
  @JoinColumn(name = "evolve_to", insertable = false, updatable = false)
  private List<Pokemons> evolveTo;

  @Column(name = "pre_evolution")
  private UUID preEvolutionId;

  @OneToOne(targetEntity = Pokemons.class)
  @JoinColumn(name = "pre_evolution", insertable = false, updatable = false)
  private Pokemons preEvolution;

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
