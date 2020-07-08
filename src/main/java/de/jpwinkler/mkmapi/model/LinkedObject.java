package de.jpwinkler.mkmapi.model;

import java.util.ArrayList;
import java.util.List;

public abstract class LinkedObject {

    private List<Link> links = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
