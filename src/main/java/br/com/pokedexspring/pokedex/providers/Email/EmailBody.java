package br.com.pokedexspring.pokedex.providers.Email;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@Data
@AllArgsConstructor
public class EmailBody {

  private String subject;

  private String htmlContent;

  private Sender sender;

  private Sender[] to;

}
