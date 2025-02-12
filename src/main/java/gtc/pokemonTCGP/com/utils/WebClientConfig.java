package gtc.pokemonTCGP.com.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private static final String API_BASE_URL = "https://api.pokemontcg.io/v2";

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(API_BASE_URL)
                .defaultHeader("X-Api-Key", "${pokemon.api.key}") // Configurar en application.properties
                .build();
    }
}