package br.com.pokedexspring.pokedex.modules.pokemons;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("get")
public class GetPokemons {

  @GetMapping("/")
  public List getAll(HttpServletRequest request){
    return new ArrayList();
  }
}
