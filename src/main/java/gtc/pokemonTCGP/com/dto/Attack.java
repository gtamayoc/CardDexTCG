package gtc.pokemonTCGP.com.dto;

import lombok.Data;
import java.util.List;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "attacks")
public class Attack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attack_name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "attack_cost", joinColumns = @JoinColumn(name = "attack_id"))
    @Column(name = "cost")
    private List<String> cost;

    @Column(name = "converted_energy_cost")
    private int convertedEnergyCost;

    @Column(name = "damage")
    private String damage;

    @Column(name = "text", length = 1000)
    private String text;
}
