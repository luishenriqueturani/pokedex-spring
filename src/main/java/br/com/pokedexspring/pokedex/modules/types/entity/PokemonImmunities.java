package br.com.pokedexspring.pokedex.modules.types.entity;

import br.com.pokedexspring.pokedex.modules.pokemons.entity.Pokemons;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pokemon_immunities")
@SQLDelete(sql = "UPDATE pokemon_immunities SET deleted_at = now() WHERE id=?")
public class PokemonImmunities {

  public PokemonImmunities(long id, long pokemonId, Pokemons pokemons, long typeId, List<Types> types) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.pokemons = pokemons;
    this.typeId = typeId;
    this.types = types;
  }

  public PokemonImmunities(long id, long pokemonId, long typeId) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.typeId = typeId;
  }

  public PokemonImmunities(long id, Pokemons pokemons, List<Types> types) {
    this.id = id;
    this.pokemons = pokemons;
    this.types = types;
  }

  @Id
  private long id;

  @Column(name = "pokemon_id")
  private long pokemonId;

  @OneToOne
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemons;

  @Column(name = "type_id")
  private long typeId;

  @OneToMany
  @JoinColumn(name = "type_id", insertable = false, updatable = false)
  private List<Types> types;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
