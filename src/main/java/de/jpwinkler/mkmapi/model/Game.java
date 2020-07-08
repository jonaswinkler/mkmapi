package de.jpwinkler.mkmapi.model;

import de.jpwinkler.mkmapi.model.LinkedObject;

public class Game extends LinkedObject {
    private int idGame;
    private String name;
    private String abbreviation;

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
