package br.com.pokedexspring.pokedex.modules.regions.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "regions")
@SQLDelete(sql = "UPDATE regions SET deleted_at = now() WHERE id=?")
public class Regions {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column
  private String name;

  @Column
  private String label;

  @Column(name = "generation_id")
  private UUID generationId;

  @OneToMany
  @JoinColumn(name = "generation_id", insertable = false, updatable = false)
  private List<Generations> generations;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
