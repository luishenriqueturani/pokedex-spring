package br.com.pokedexspring.pokedex.modules.moves.entity;

import br.com.pokedexspring.pokedex.modules.types.entity.Types;
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
@Entity(name = "moves")
@SQLDelete(sql = "UPDATE moves SET deleted_at = now() WHERE id=?")
public class Moves {

  public Moves(long id, String name, String label, long typeId, Types types, String category) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.typeId = typeId;
    this.types = types;
    this.category = category;
  }

  public Moves(long id, String name, String label, long typeId, String category) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.typeId = typeId;
    this.category = category;
  }

  public Moves(long id, String name, String label, Types types, String category) {
    this.id = id;
    this.name = name;
    this.label = label;
    this.types = types;
    this.category = category;
  }

  @Id
  private long id;

  @Column
  private String name;

  @Column
  private String label;

  @Column(name = "type_id")
  private long typeId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type_id", insertable = false, updatable = false)
  private Types types;

  @Column
  private String category;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;

}
