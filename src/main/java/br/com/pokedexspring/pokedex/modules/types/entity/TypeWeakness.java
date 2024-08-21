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
@Entity(name = "type_weakness")
@SQLDelete(sql = "UPDATE type_weakness SET deleted_at = now() WHERE id=?")
public class TypeWeakness {

  public TypeWeakness(long id, long typeRefId, Types typeRef, long weakId, Types weak) {
    this.id = id;
    this.typeRefId = typeRefId;
    this.typeRef = typeRef;
    this.weakId = weakId;
    this.weak = weak;
  }

  public TypeWeakness(long id, Types typeRef, Types weak) {
    this.id = id;
    this.typeRef = typeRef;
    this.weak = weak;
  }

  public TypeWeakness(long id, long typeRefId, long weakId) {
    this.id = id;
    this.typeRefId = typeRefId;
    this.weakId = weakId;
  }

  @Id
  private long id;

  @Column(name = "type_ref")
  private long typeRefId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type_ref", insertable = false, updatable = false)
  private Types typeRef;

  @Column(name = "weak")
  private long weakId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "weak", insertable = false, updatable = false)
  private Types weak;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
