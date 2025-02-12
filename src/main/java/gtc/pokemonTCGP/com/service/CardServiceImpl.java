package gtc.pokemonTCGP.com.service;

import gtc.pokemonTCGP.com.dto.Card;
import gtc.pokemonTCGP.com.dto.CardResponse;
import gtc.pokemonTCGP.com.utils.AbstractClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CardServiceImpl extends AbstractClient implements CardService {

    public CardServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public List<Card> getAllCards() {
        String uri = baseUrl + "/cards";
        try {
            ResponseEntity<CardResponse> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<CardResponse>() {
                    }
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                return Objects.requireNonNull(response.getBody()).getData();
            }
        } catch (Exception e) {
            log.error("Error fetching cards: ", e);
            throw new RuntimeException("Error fetching cards from API");
        }
        return null;
    }

}