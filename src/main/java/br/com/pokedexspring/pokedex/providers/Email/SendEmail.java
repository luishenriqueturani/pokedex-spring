package br.com.pokedexspring.pokedex.providers.Email;

import br.com.pokedexspring.pokedex.providers.Requests;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

public class SendEmail {
  private static final Dotenv dotenv = Dotenv.load();

  public String send(String subject, String emailBody){
    Requests requests = new Requests();

    Gson gson = new Gson();

    String apiKey = dotenv.get("sendinblue.api.key");

    //System.out.println(apiKey);

    Map<String, String> headers = Map.of(
        "api-key", apiKey,
        "Accept", "application/json",
        "Content-Type", "application/json"
    );

    String body = gson.toJson(new EmailBody(
        subject,
        emailBody,
        new Sender(
            "Testezildo",
            "turaniluishenrique8@gmail.com"),
        new Sender[]{new Sender("Testezildo",
            "turaniluishenrique8@gmail.com")}
    ));

    try {

      HttpResponse<String> response = requests.sendRequest("https://api.brevo.com/v3/smtp/email", Requests.HttpMethod.POST, Optional.of(headers), Optional.ofNullable(body));

      System.out.println(response);
      System.out.println(response.body());

      return response.toString();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
