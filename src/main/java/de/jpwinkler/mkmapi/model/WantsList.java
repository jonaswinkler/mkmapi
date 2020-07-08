package de.jpwinkler.mkmapi.model;

import java.util.ArrayList;
import java.util.List;

public class WantsList extends LinkedObject {

    private int idWantslist;
    private Game game;
    private String name;
    private int itemCount;
    private List<WantsListItem> item = new ArrayList<>();

    public int getIdWantslist() {
        return idWantslist;
    }

    public void setIdWantslist(int idWantslist) {
        this.idWantslist = idWantslist;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<WantsListItem> getItem() {
        return item;
    }

    public void setItem(List<WantsListItem> item) {
        this.item = item;
    }
}
