package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Data
@Entity
@Table(name = "cardmarket_prices")
public class CardMarketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "cardmarket_prices_values", joinColumns = @JoinColumn(name = "cardmarket_prices_id"))
    @MapKeyColumn(name = "price_type")
    @Column(name = "price_value")
    private Map<String, Double> prices;
}
