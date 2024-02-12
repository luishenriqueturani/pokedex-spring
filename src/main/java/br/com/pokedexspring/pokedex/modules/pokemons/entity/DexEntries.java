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
@Where(clause = "deleted_at IS NULL")
public class DexEntries {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "pokemon_id")
  private UUID pokemonId;

  @OneToOne
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemons;

  @Column(name = "game_id")
  private UUID gameId;

  @OneToOne
  @JoinColumn(name = "game_id", insertable = false, updatable = false)
  private Games games;

  @Column(length = 1028)
  private String entry;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
