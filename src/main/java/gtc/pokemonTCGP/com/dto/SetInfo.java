package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Map;

@Data
@Embeddable
public class SetInfo {

    @Column(name = "set_id")
    private String id;

    @Column(name = "set_name")
    private String name;

    @Column(name = "set_series")
    private String series;

    @Column(name = "printed_total")
    private int printedTotal;

    @Column(name = "total")
    private int total;

    @ElementCollection
    private Map<String, String> legalities;

    @Column(name = "ptcgo_code")
    private String ptcgoCode;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "updated_at")
    private String updatedAt;
}
