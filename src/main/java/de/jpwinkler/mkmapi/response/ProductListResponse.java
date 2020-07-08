package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.LinkedObject;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class ProductListResponse extends LinkedObject {

    private String productsfile;
    private String mime;

    public String getProductsfile() {
        return productsfile;
    }

    public void setProductsfile(String productsfile) {
        this.productsfile = productsfile;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }
}
