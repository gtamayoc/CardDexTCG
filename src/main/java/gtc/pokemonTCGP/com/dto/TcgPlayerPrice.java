package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Data
@Entity
@Table(name = "tcgplayer_prices")
public class TcgPlayerPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "tcgplayer_normal_prices", joinColumns = @JoinColumn(name = "tcgplayer_prices_id"))
    @MapKeyColumn(name = "price_type")
    @Column(name = "price_value")
    private Map<String, Double> normal;

    @ElementCollection
    @CollectionTable(name = "tcgplayer_holofoil_prices", joinColumns = @JoinColumn(name = "tcgplayer_prices_id"))
    @MapKeyColumn(name = "price_type")
    @Column(name = "price_value")
    private Map<String, Double> holofoil;

    @ElementCollection
    @CollectionTable(name = "tcgplayer_reverse_holofoil_prices", joinColumns = @JoinColumn(name = "tcgplayer_prices_id"))
    @MapKeyColumn(name = "price_type")
    @Column(name = "price_value")
    private Map<String, Double> reverseHolofoil;
}