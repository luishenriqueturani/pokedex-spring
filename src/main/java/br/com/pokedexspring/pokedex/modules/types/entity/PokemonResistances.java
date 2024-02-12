package br.com.pokedexspring.pokedex.modules.types.entity;

import br.com.pokedexspring.pokedex.modules.pokemons.entity.Pokemons;
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
@SQLDelete(sql = "UPDATE pokemon_resistances SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class PokemonResistances {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private UUID pokemonId;

  @OneToOne
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemons;

  @Column
  private UUID typeId;

  @OneToMany
  @JoinColumn(name = "type_id", insertable = false, updatable = false)
  private List<Types> types;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
