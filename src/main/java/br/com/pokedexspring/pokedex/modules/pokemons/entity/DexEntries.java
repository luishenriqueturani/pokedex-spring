package br.com.pokedexspring.pokedex.modules.pokemons.entity;

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
@Entity(name = "dex_entries")
@SQLDelete(sql = "UPDATE dex_entries SET deleted_at = now() WHERE id=?")
public class DexEntries {

  public DexEntries(long id, long pokemonId, Pokemons pokemons, long gameId, Games games, String entry) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.pokemons = pokemons;
    this.gameId = gameId;
    this.games = games;
    this.entry = entry;
  }

  public DexEntries(long id, long pokemonId, long gameId, String entry) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.gameId = gameId;
    this.entry = entry;
  }

  public DexEntries(long id, Pokemons pokemons, Games games, String entry) {
    this.id = id;
    this.pokemons = pokemons;
    this.games = games;
    this.entry = entry;
  }



  @Id
  private long id;

  @Column(name = "pokemon_id")
  private long pokemonId;

  @OneToOne
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemons;

  @Column(name = "game_id")
  private long gameId;

  @OneToOne
  @JoinColumn(name = "game_id", insertable = false, updatable = false)
  private Games games;

  @Column(length = 1028)
  private String entry;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
