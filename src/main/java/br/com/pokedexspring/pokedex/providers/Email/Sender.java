package br.com.pokedexspring.pokedex.providers.Email;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sender {

  private String name;

  private String email;
}
