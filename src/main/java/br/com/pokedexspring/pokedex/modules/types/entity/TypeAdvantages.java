package br.com.pokedexspring.pokedex.modules.types.entity;

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
@Entity(name = "type_advantages")
@SQLDelete(sql = "UPDATE type_advantages SET deleted_at = now() WHERE id=?")
public class TypeAdvantages {

  public TypeAdvantages(long id, long typeRefId, Types typeRef, long advantageId, Types advantage) {
    this.id = id;
    this.typeRefId = typeRefId;
    this.typeRef = typeRef;
    this.advantageId = advantageId;
    this.advantage = advantage;
  }

  public TypeAdvantages(long id, long typeRefId, long advantageId) {
    this.id = id;
    this.typeRefId = typeRefId;
    this.advantageId = advantageId;
  }

  public TypeAdvantages(long id, Types typeRef, Types advantage) {
    this.id = id;
    this.typeRef = typeRef;
    this.advantage = advantage;
  }

  @Id
  private long id;

  @Column(name = "type_ref")
  private long typeRefId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type_ref", insertable = false, updatable = false)
  private Types typeRef;

  @Column(name = "advantage")
  private long advantageId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "advantage", insertable = false, updatable = false)
  private Types advantage;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
