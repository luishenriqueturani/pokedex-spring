package br.com.pokedexspring.pokedex.modules.abilities.entity;

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
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE pokemon_ability SET deleted_at = now() WHERE id=?")
public class PokemonAbility {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "pokemon_id")
  private UUID pokemonId;

  @OneToOne(targetEntity = Pokemons.class)
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemon;

  @Column(name = "ability_id")
  private UUID abilityId;

  @OneToOne
  @JoinColumn(name = "ability_id", insertable = false, updatable = false)
  private Abilities abilities;

  @Column
  private String abilityType;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;
  @Column
  private LocalDateTime deletedAt;
}
