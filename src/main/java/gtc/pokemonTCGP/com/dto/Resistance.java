package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resistances")
public class Resistance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resistance_type")
    private String type;

    @Column(name = "resistance_value")
    private String value;
}