package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Legalities {
    @Column(name = "standard")
    private String standard;

    @Column(name = "expanded")
    private String expanded;

    @Column(name = "unlimited")
    private String unlimited;
}