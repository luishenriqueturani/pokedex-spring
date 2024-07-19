package br.com.pokedexspring.pokedex.modules.abilities.entity;

import br.com.pokedexspring.pokedex.modules.regions.entity.Generations;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE abilities SET deleted_at = now() WHERE id=?")
public class Abilities {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String name;

  @Column
  private String description;

  @Column(name = "generation_id")
  private UUID generation;

  @OneToMany(targetEntity = Generations.class)
  @JoinColumn(name = "generation_id", insertable = false, updatable = false)
  private List<Generations> generations;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
