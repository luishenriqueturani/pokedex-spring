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
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE games SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Games {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String name;

  @Column(name = "region_id")
  private UUID regionId;

  @OneToOne
  @JoinColumn(name = "region_id", insertable = false, updatable = false)
  private Regions regions;

  @Column(name = "generation_id")
  private UUID generationId;

  @OneToOne
  @JoinColumn(name = "generation_id", insertable = false, updatable = false)
  private Generations generations;

  @Column
  private String platform;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
