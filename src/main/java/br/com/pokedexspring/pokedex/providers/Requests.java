package br.com.pokedexspring.pokedex.providers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

public class Requests {

  public enum HttpMethod {
    GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS, TRACE
  }

  public HttpResponse<String> sendRequest(String url, HttpMethod method, Optional<Map<String, String>> headers, Optional<String> body) throws Exception {
    try (HttpClient client = HttpClient.newHttpClient()) {
      Thread.sleep(1000);

      HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
          .uri(URI.create(url))
          .method(method.toString(), body.map(HttpRequest.BodyPublishers::ofString)
              .orElse(HttpRequest.BodyPublishers.noBody()));

      headers.ifPresent(h -> h.forEach(requestBuilder::header));

      HttpRequest request = requestBuilder.build();

      return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
  }
}
