package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "weaknesses")
public class Weakness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weakness_type")
    private String type;

    @Column(name = "weakness_value")
    private String value;
}
