package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SetHash {

    @Column(name = "image_symbol")
    private String symbol;

    @Column(name = "image_logo")
    private String logo;
}
