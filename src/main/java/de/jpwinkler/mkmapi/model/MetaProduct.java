package de.jpwinkler.mkmapi.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class MetaProduct extends LinkedObject {
    private int idMetaproduct;
    private String enName;
    private String locName;
    private List<LocalizedName> localization = new ArrayList<>();
    private String image;
    private List<Product> product = new ArrayList<>();

    public int getIdMetaproduct() {
        return idMetaproduct;
    }

    public void setIdMetaproduct(int idMetaproduct) {
        this.idMetaproduct = idMetaproduct;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public List<LocalizedName> getLocalization() {
        return localization;
    }

    public void setLocalization(List<LocalizedName> localization) {
        this.localization = localization;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
