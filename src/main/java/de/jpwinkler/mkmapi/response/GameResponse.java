package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.Game;
import de.jpwinkler.mkmapi.model.LinkedObject;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class GameResponse extends LinkedObject {

    private List<Game> game = new ArrayList<>();

    public List<Game> getGame() {
        return game;
    }

    public void setGame(List<Game> game) {
        this.game = game;
    }
}
