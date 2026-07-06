package ar.edu.utn.frba.ddsi.climalert.models.adapters;

import ar.edu.utn.frba.ddsi.climalert.config.WeatherApiProperties;
import ar.edu.utn.frba.ddsi.climalert.models.adapters.dto.CurrentWeatherResponse;
import ar.edu.utn.frba.ddsi.climalert.models.adapters.dto.WeatherResponse;
import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherApiAdapter implements ClimaAdapter {
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  private final RestTemplate restTemplate;
  private final WeatherApiProperties properties;

  public WeatherApiAdapter(RestTemplate restTemplate, WeatherApiProperties properties) {
    this.restTemplate = restTemplate;
    this.properties = properties;
  }

  @Override
  public Clima obtenerClimaActual(){
    URI uri =
        UriComponentsBuilder.fromUriString(properties.getBaseUrl())
            .path("/current.json")
            .queryParam("key", properties.getApiKey())
            .queryParam("q", properties.getLocation())
            .build()
            .toUri();

    WeatherResponse response = restTemplate.getForObject(uri, WeatherResponse.class);

    CurrentWeatherResponse current = response.getCurrent();

    LocalDateTime fecha = LocalDateTime.parse(current.getUltimaActualizacion(), FORMATTER);

    return new Clima(current.getTemperatura(), current.getHumedad(), fecha);
  }
}