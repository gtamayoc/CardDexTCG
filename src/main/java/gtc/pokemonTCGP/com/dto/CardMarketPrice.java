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

    @Column(name = "average_sell_price")
    private Double averageSellPrice;

    @Column(name = "low_price")
    private Double lowPrice;

    @Column(name = "trend_price")
    private Double trendPrice;

    @Column(name = "german_pro_low")
    private Double germanProLow;

    @Column(name = "suggested_price")
    private Double suggestedPrice;

    @Column(name = "reverse_holo_sell")
    private Double reverseHoloSell;

    @Column(name = "reverse_holo_low")
    private Double reverseHoloLow;

    @Column(name = "reverse_holo_trend")
    private Double reverseHoloTrend;

    @Column(name = "low_price_ex_plus")
    private Double lowPriceExPlus;

    @Column(name = "avg_1")
    private Double avg1;

    @Column(name = "avg_7")
    private Double avg7;

    @Column(name = "avg_30")
    private Double avg30;

    @Column(name = "reverse_holo_avg_1")
    private Double reverseHoloAvg1;

    @Column(name = "reverse_holo_avg_7")
    private Double reverseHoloAvg7;

    @Column(name = "reverse_holo_avg_30")
    private Double reverseHoloAvg30;
}
