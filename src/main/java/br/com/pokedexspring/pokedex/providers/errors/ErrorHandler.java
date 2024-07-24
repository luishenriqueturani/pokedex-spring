package br.com.pokedexspring.pokedex.providers.errors;

import br.com.pokedexspring.pokedex.providers.Email.SendEmail;

public class ErrorHandler extends RuntimeException {
  public ErrorHandler(String message){
    super(message);
    sendErrorEmail(message);
  }

  private void sendErrorEmail(String message){
    SendEmail sendEmail = new SendEmail();

    sendEmail.send("Erro na Pokédex", "<p>"+ message +"</p>");
  }

}
