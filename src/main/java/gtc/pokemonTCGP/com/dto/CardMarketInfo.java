package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cardmarket_info")
public class CardMarketInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cardmarket_url")
    private String url;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardmarket_prices_id")
    private CardMarketPrice prices;
}