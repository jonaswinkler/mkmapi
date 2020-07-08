package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.Expansion;
import de.jpwinkler.mkmapi.model.LinkedObject;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class ExpansionResponse extends LinkedObject {

    private List<Expansion> expansion = new ArrayList<>();

    public List<Expansion> getExpansion() {
        return expansion;
    }

    public void setExpansion(List<Expansion> expansion) {
        this.expansion = expansion;
    }
}
