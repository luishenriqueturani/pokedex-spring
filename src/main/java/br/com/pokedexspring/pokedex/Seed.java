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

    String pokeapiBaseUrl = "https://pokeapi.co/api/v2/";

    Requests requests = new Requests();

    SendEmail sendEmail = new SendEmail();

    Gson gson = new Gson();

    //primeiro são buscadas as regiões


    for (int i = 1; i <= 2 ; i++) {
      try{
        //buscar os dados do pokémon
          //Aqui vem também os ataques
        HttpResponse<String> responseGetPokemon = requests.sendRequest(pokeapiBaseUrl + "pokemon/" + i, Requests.HttpMethod.GET, Optional.empty(), Optional.empty());


        //buscar spécies do pokémon, é assim que definiram
          //precisa buscar para ter os dados de entrada da pokédex, dados de evolução e como evolui.


        //buscar a corrente de evoluções
          //só há o registro de para quem evolui, então para juntar com de quem evolui precisará de lógica

        //salvar em banco


      }catch (Exception exception){

      }


    }

  }
}
