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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pokemon_weakness")
@SQLDelete(sql = "UPDATE pokemon_weakness SET deleted_at = now() WHERE id=?")
public class PokemonWeakness {

  public PokemonWeakness(long id, long pokemonId, Pokemons pokemon, long typeId, Types type) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.pokemon = pokemon;
    this.typeId = typeId;
    this.type = type;
  }

  public PokemonWeakness(long id, long pokemonId, long typeId) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.typeId = typeId;
  }

  public PokemonWeakness(long id, Pokemons pokemon, Types type) {
    this.id = id;
    this.pokemon = pokemon;
    this.type = type;
  }

  @Id
  private long id;

  @Column(name = "pokemon_id")
  private long pokemonId;

  @OneToOne(targetEntity = Pokemons.class)
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemon;

  @Column(name = "type_id")
  private long typeId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type_id", insertable = false, updatable = false)
  private Types type;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
