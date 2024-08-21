package br.com.pokedexspring.pokedex.modules.abilities.entity;

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
@Entity(name = "pokemon_ability")
@SQLDelete(sql = "UPDATE pokemon_ability SET deleted_at = now() WHERE id=?")
public class PokemonAbility {

  public PokemonAbility(long id, long pokemonId, Pokemons pokemon, long abilityId, Abilities abilities, String abilityType) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.pokemon = pokemon;
    this.abilityId = abilityId;
    this.abilities = abilities;
    this.abilityType = abilityType;
  }

  public PokemonAbility(long id, long pokemonId, long abilityId, String abilityType) {
    this.id = id;
    this.pokemonId = pokemonId;
    this.abilityId = abilityId;
    this.abilityType = abilityType;
  }

  public PokemonAbility(long id, Pokemons pokemon, Abilities abilities, String abilityType) {
    this.id = id;
    this.pokemon = pokemon;
    this.abilities = abilities;
    this.abilityType = abilityType;
  }

  @Id
  private long id;

  @Column(name = "pokemon_id")
  private long pokemonId;

  @OneToOne(targetEntity = Pokemons.class)
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemon;

  @Column(name = "ability_id")
  private long abilityId;

  @OneToOne
  @JoinColumn(name = "ability_id", insertable = false, updatable = false)
  private Abilities abilities;

  @Column(name = "ability_type")
  private String abilityType;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
