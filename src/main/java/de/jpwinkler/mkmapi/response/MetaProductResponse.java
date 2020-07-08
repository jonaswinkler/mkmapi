package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.LinkedObject;
import de.jpwinkler.mkmapi.model.MetaProduct;
import de.jpwinkler.mkmapi.model.Product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class MetaProductResponse extends LinkedObject {

    private MetaProduct metaProduct;

    private List<Product> product = new ArrayList<>();

    @XmlElement(name = "metaproduct")
    public MetaProduct getMetaProduct() {
        return metaProduct;
    }

    public void setMetaProduct(MetaProduct metaProduct) {
        this.metaProduct = metaProduct;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
