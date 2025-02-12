package gtc.pokemonTCGP.com.dto;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Embeddable
public class ImageInfo {

    @Column(name = "image_small")
    private String small;

    @Column(name = "image_large")
    private String large;
}
