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
@Entity(name = "generations")
@SQLDelete(sql = "UPDATE generations SET deleted_at = now() WHERE id=?")
public class Generations {

  public Generations(UUID regionId, int number) {
    this.regionId = regionId;
    this.number = number;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private int number;

  @Column(name = "region_id")
  private UUID regionId;

  @OneToOne
  @JoinColumn(name = "region_id", insertable = false, updatable = false)
  private Regions regions;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;

}
