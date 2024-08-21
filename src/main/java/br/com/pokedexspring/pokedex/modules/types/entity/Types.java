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
@Entity(name = "types")
@SQLDelete(sql = "UPDATE types SET deleted_at = now() WHERE id=?")
public class Types {

  public Types(long id, String name, String label) {
    this.id = id;
    this.name = name;
    this.label = label;
  }

  @Id
  private long id;

  @Column
  private String name;

  @Column
  private String label;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
