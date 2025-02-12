package gtc.pokemonTCGP.com.dto;

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

    @Column(name = "number")
    private String number;

    @Column(name = "artist")
    private String artist;

    @Column(name = "rarity")
    private String rarity;

    @ElementCollection
    @CollectionTable(name = "card_types", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "type")
    private List<String> types;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tcgplayer_id")
    private TcgPlayerInfo tcgplayer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardmarket_id")
    private CardMarketInfo cardmarket;
}