package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tcgplayer_info")
public class TcgPlayerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tcgplayer_url")
    private String url;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tcgplayer_prices_id")
    private TcgPlayerPrice prices;
}
