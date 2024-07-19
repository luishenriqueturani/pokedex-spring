package br.com.pokedexspring.pokedex.modules.moves.entity;

import br.com.pokedexspring.pokedex.modules.types.entity.Types;
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
@SQLDelete(sql = "UPDATE moves SET deleted_at = now() WHERE id=?")
public class Moves {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String name;

  @Column(name = "type_id")
  private UUID typeId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type_id", insertable = false, updatable = false)
  private Types types;

  @Column
  private String category;


  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;

}
