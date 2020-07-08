package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.LinkedObject;
import de.jpwinkler.mkmapi.model.Product;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class ProductResponse extends LinkedObject {

    private List<Product> product = new ArrayList<>();

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
