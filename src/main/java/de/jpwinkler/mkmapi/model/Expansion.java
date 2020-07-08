package de.jpwinkler.mkmapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expansion extends LinkedObject {

    private int idExpansion;
    private String enName;
    private List<LocalizedName> localization = new ArrayList<>();
    private String abbreviation;
    private int icon;
    private Date releaseDate;
    private boolean isReleased;
    private int idGame;

    public int getIdExpansion() {
        return idExpansion;
    }

    public void setIdExpansion(int idExpansion) {
        this.idExpansion = idExpansion;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public List<LocalizedName> getLocalization() {
        return localization;
    }

    public void setLocalization(List<LocalizedName> localization) {
        this.localization = localization;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isReleased() {
        return isReleased;
    }

    public void setReleased(boolean released) {
        isReleased = released;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }
}
