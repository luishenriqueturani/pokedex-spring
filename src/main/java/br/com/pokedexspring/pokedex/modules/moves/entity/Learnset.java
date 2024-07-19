package br.com.pokedexspring.pokedex.modules.moves.entity;

import br.com.pokedexspring.pokedex.modules.pokemons.entity.Pokemons;
import br.com.pokedexspring.pokedex.modules.regions.entity.Games;
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
@SQLDelete(sql = "UPDATE learnset SET deleted_at = now() WHERE id=?")
public class Learnset {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "pokemon_id")
  private UUID pokemonId;

  @OneToOne(targetEntity = Pokemons.class)
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemon;

  @Column(name = "move_id")
  private UUID moveId;

  @OneToOne(targetEntity = Moves.class)
  @JoinColumn(name = "move_id", insertable = false, updatable = false)
  private Moves move;

  @Column
  private Integer power;

  @Column
  private Integer accuracy;

  @Column
  private Integer pp;

  @Column
  private String description;

  @Column(name = "game_id")
  private UUID gameId;

  @OneToOne(targetEntity = Games.class)
  @JoinColumn(name = "game_id", insertable = false, updatable = false)
  private Games game;

  @Column
  private String learnMethod;

  @Column
  private String joker;


  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
