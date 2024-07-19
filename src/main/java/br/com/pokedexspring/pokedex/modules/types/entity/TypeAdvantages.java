package br.com.pokedexspring.pokedex.modules.types.entity;

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
@Entity(name = "type_advantages")
@SQLDelete(sql = "UPDATE type_advantages SET deleted_at = now() WHERE id=?")
public class TypeAdvantages {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "type_ref")
  private UUID typeRefId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "type_ref", insertable = false, updatable = false)
  private Types typeRef;

  @Column(name = "advantage")
  private UUID advantageId;

  @OneToOne(targetEntity = Types.class)
  @JoinColumn(name = "advantage", insertable = false, updatable = false)
  private Types advantage;


  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
