package br.com.pokedexspring.pokedex;

import br.com.pokedexspring.pokedex.providers.Email.EmailBody;
import br.com.pokedexspring.pokedex.providers.Email.SendEmail;
import br.com.pokedexspring.pokedex.providers.Email.Sender;
import br.com.pokedexspring.pokedex.providers.Requests;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

public class Seed {


  public static void main(String[] args) {

    Requests requests = new Requests();

    SendEmail sendEmail = new SendEmail();

    Gson gson = new Gson();

    

    for (int i = 1; i <= 2 ; i++) {

      //buscar os dados do pokémon


      //buscar spécies do pokémon, é assim que definiram


      //buscar a corrente de evoluções

      //salvar em banco


    }

  }
}
