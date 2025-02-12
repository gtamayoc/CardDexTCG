package gtc.pokemonTCGP.com.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ancient_traits")
public class AncientTrait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "text", length = 1000)
    private String text;
}