package gtc.pokemonTCGP.com.dto;

import java.util.List;

public class CardResponse {
    private List<Card> data;

    public List<Card> getData() {
        return data;
    }

    public void setData(List<Card> data) {
        this.data = data;
    }
}
