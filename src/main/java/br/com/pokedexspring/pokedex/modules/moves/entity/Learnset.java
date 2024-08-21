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

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "learnset")
@SQLDelete(sql = "UPDATE learnset SET deleted_at = now() WHERE id=?")
public class Learnset {

  public Learnset(long id, long pokemonId, Pokemons pokemon, long moveId, Moves move, Integer power, Integer accuracy, Integer pp, String description, long gameId, Games game, String learnMethod, String joker) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.pokemon = pokemon;
    this.moveId = moveId;
    this.move = move;
    this.power = power;
    this.accuracy = accuracy;
    this.pp = pp;
    this.description = description;
    this.gameId = gameId;
    this.game = game;
    this.learnMethod = learnMethod;
    this.joker = joker;
  }

  public Learnset(long id, long pokemonId, long moveId, Integer power, Integer accuracy, Integer pp, String description, long gameId, String learnMethod, String joker) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.moveId = moveId;
    this.power = power;
    this.accuracy = accuracy;
    this.pp = pp;
    this.description = description;
    this.gameId = gameId;
    this.learnMethod = learnMethod;
    this.joker = joker;
  }

  public Learnset(long id, Pokemons pokemon, Moves move, Integer power, Integer accuracy, Integer pp, String description, Games game, String learnMethod, String joker) {
    this.id = id;
    this.pokemon = pokemon;
    this.move = move;
    this.power = power;
    this.accuracy = accuracy;
    this.pp = pp;
    this.description = description;
    this.game = game;
    this.learnMethod = learnMethod;
    this.joker = joker;
  }

  @Id
  private long id;

  @Column(name = "pokemon_id")
  private long pokemonId;

  @OneToOne(targetEntity = Pokemons.class)
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemon;

  @Column(name = "move_id")
  private long moveId;

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
  private long gameId;

  @OneToOne(targetEntity = Games.class)
  @JoinColumn(name = "game_id", insertable = false, updatable = false)
  private Games game;

  @Column(name = "learn_method")
  private String learnMethod;

  @Column
  private String joker;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
