package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.MetaProduct;
import de.jpwinkler.mkmapi.model.Product;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class MetaProductListResponse {

    public static class InnerObject {
        private MetaProduct metaproduct;
        private List<Product> product;

        public MetaProduct getMetaproduct() {
            return metaproduct;
        }

        public void setMetaproduct(MetaProduct metaproduct) {
            this.metaproduct = metaproduct;
        }

        public List<Product> getProduct() {
            return product;
        }

        public void setProduct(List<Product> product) {
            this.product = product;
        }
    }

    private List<InnerObject> metaproduct = new ArrayList<>();

    public List<InnerObject> getMetaproduct() {
        return metaproduct;
    }

    public void setMetaproduct(List<InnerObject> metaproduct) {
        this.metaproduct = metaproduct;
    }
}
