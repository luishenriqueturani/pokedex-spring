package br.com.pokedexspring.pokedex;

import br.com.pokedexspring.pokedex.modules.regions.entity.Games;
import br.com.pokedexspring.pokedex.modules.regions.entity.Generations;
import br.com.pokedexspring.pokedex.modules.regions.entity.Regions;
import br.com.pokedexspring.pokedex.modules.regions.repository.IGamesRepository;
import br.com.pokedexspring.pokedex.modules.regions.repository.IGenerationRepository;
import br.com.pokedexspring.pokedex.modules.regions.repository.IRegionRepository;
import br.com.pokedexspring.pokedex.providers.Email.SendEmail;
import br.com.pokedexspring.pokedex.providers.Requests;
import br.com.pokedexspring.pokedex.providers.errors.ErrorHandler;
import br.com.pokedexspring.pokedex.providers.pokeapi.region.ResponseRegion;
import br.com.pokedexspring.pokedex.providers.pokeapi.region.ResponseRegions;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.http.HttpResponse;
import java.util.Optional;

public class Seed {


  public static void main(String[] args) {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);

    IRegionRepository regionRepository = context.getBean(IRegionRepository.class);

    IGamesRepository gamesRepository = context.getBean(IGamesRepository.class);

    IGenerationRepository generationRepository = context.getBean(IGenerationRepository.class);

    String pokeapiBaseUrl = "https://pokeapi.co/api/v2/";

    Requests requests = new Requests();

    SendEmail sendEmail = new SendEmail();

    //Services services = new Services();

    Gson gson = new Gson();

    try{
      HttpResponse<String> responseRegions = requests.sendRequest(pokeapiBaseUrl + "region", Requests.HttpMethod.GET, Optional.empty(), Optional.empty());
      //System.out.println(responseRegions.body());
      ResponseRegions resRegions = gson.fromJson(responseRegions.body(), ResponseRegions.class);


      for (Joker regions : resRegions.getResults()){

        HttpResponse<String> responseRegion = requests.sendRequest(regions.getUrl(), Requests.HttpMethod.GET, Optional.empty(), Optional.empty());

        ResponseRegion region = gson.fromJson(responseRegion.body(), ResponseRegion.class);

        //salvar a região e geração
        Regions newRegion = regionRepository.save(new Regions(StringUtils.capitalize(region.getName()), region.getName()));

        Generations newGeneration = generationRepository.save(new Generations( newRegion.getId(), region.getId() ));

        for (Joker games : region.getVersion_group()){

          String[] versions = games.getName().split("-");

          for (String v : versions){
            // salvar o jogo
            Games gamesVerify = gamesRepository.findOneByLabel(v);

            if(gamesVerify != null){
              continue;
            }

            Games newGame = gamesRepository.save(new Games(StringUtils.capitalize(v), v, newRegion.getId(), newGeneration.getId()));

          }

        }


      }

    }catch (Exception e) {
      throw new ErrorHandler(e.getMessage());
    }
    //primeiro são buscadas as regiões


    for (int i = 1; i <= 2 ; i++) {
      try{
        //buscar os dados do pokémon
          //Aqui vem também os ataques
        //HttpResponse<String> responseGetPokemon = requests.sendRequest(pokeapiBaseUrl + "pokemon/" + i, Requests.HttpMethod.GET, Optional.empty(), Optional.empty());


        //buscar spécies do pokémon, é assim que definiram
          //precisa buscar para ter os dados de entrada da pokédex, dados de evolução e como evolui.


        //buscar a corrente de evoluções
          //só há o registro de para quem evolui, então para juntar com de quem evolui precisará de lógica

        //salvar em banco


      }catch (Exception e){
        throw new ErrorHandler(e.getMessage());
      }


    }

  }

}
