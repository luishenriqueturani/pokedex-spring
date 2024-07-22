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
@Entity(name = "types")
@SQLDelete(sql = "UPDATE types SET deleted_at = now() WHERE id=?")
public class Types {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String name;

  @Column
  private String label;


  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
