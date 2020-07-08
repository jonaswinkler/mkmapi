package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.Expansion;
import de.jpwinkler.mkmapi.model.LinkedObject;
import de.jpwinkler.mkmapi.model.Product;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class SinglesResponse extends LinkedObject {

    private List<Product> single = new ArrayList<>();

    private Expansion expansion;

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public List<Product> getSingle() {
        return single;
    }

    public void setSingle(List<Product> single) {
        this.single = single;
    }
}
