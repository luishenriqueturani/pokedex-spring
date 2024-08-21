package br.com.pokedexspring.pokedex.modules.regions.entity;

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
@Entity(name = "generations")
@SQLDelete(sql = "UPDATE generations SET deleted_at = now() WHERE id=?")
public class Generations {

  public Generations(long id, long regionId, int number) {
    this.id = id;
    this.regionId = regionId;
    this.number = number;
  }

  public Generations(long id, int number, long regionId, Regions regions) {
    this.id = id;
    this.number = number;
    this.regionId = regionId;
    this.regions = regions;
  }

  public Generations(long id, int number, Regions regions) {
    this.id = id;
    this.number = number;
    this.regions = regions;
  }

  @Id
  private long id;

  @Column
  private int number;

  @Column(name = "region_id")
  private long regionId;

  @OneToOne
  @JoinColumn(name = "region_id", insertable = false, updatable = false)
  private Regions regions;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;

}
