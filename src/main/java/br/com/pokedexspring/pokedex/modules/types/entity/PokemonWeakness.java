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
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pokemon_weakness")
@SQLDelete(sql = "UPDATE pokemon_weakness SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class PokemonWeakness {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "pokemon_id")
  private UUID pokemonId;

  @OneToOne(targetEntity = Pokemons.class)
  @JoinColumn(name = "pokemon_id", insertable = false, updatable = false)
  private Pokemons pokemon;

  @Column(name = "type_id")
  private UUID typeId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type_id", insertable = false, updatable = false)
  private Types type;


  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
