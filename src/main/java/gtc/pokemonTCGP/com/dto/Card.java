package gtc.pokemonTCGP.com.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "supertype")
    private String supertype;

    @ElementCollection
    @CollectionTable(name = "card_subtypes", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "subtype")
    private List<String> subtypes;

    @Column(name = "level")
    private String level;

    @Column(name = "hp")
    private String hp;

    @ElementCollection
    @CollectionTable(name = "card_types", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "type")
    private List<String> types;

    @ElementCollection
    @CollectionTable(name = "evolves_to", joinColumns = @JoinColumn(name = "card_id"))
    private List<String> evolvesTo;

    @Column(name = "evolves_from")
    private String evolvesFrom;

    @ElementCollection
    @CollectionTable(name = "rules", joinColumns = @JoinColumn(name = "card_id"))
    private List<String> rules;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ancient_trait_id")
    private AncientTrait ancientTrait;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private List<Ability> abilities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private List<Attack> attacks;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private List<Weakness> weaknesses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private List<Resistance> resistances;

    @Column(name = "number")
    private String number;

    @Column(name = "artist")
    private String artist;

    @Column(name = "rarity")
    private String rarity;

    @ElementCollection
    @CollectionTable(name = "retreat_costs", joinColumns = @JoinColumn(name = "card_id"))
    private List<String> retreatCost;

    @Column(name = "converted_retreat_cost")
    private Integer convertedRetreatCost;

    @Embedded
    private SetInfo set;

    @Column(name = "flavor_text", length = 1000)
    private String flavorText;

    @ElementCollection
    @CollectionTable(name = "national_pokedex_numbers", joinColumns = @JoinColumn(name = "card_id"))
    private List<Integer> nationalPokedexNumbers;

    @Embedded
    private Legalities legalities;

    @Column(name = "regulation_mark")
    private String regulationMark;

    @Embedded
    private ImageInfo images;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tcgplayer_id")
    private TcgPlayerInfo tcgplayer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardmarket_id")
    private CardMarketInfo cardmarket;
}