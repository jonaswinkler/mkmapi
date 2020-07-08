package de.jpwinkler.mkmapi.model;

import java.util.List;

public class WantsListItem {
    private String idWant;
    private Integer count;
    private Double wishPrice;
    private Double fromPrice;
    private Boolean mailAlert;
    private String type;

    private Integer idProduct;
    private Product product;

    private Integer idMetaproduct;
    private MetaProduct metaproduct;

    private List<Integer> idLanguage;
    private String minCondition;
    private Boolean isFoil;
    private Boolean isSigned;
    private Boolean isAltered;
    private Boolean isFirstEd;

    public String getIdWant() {
        return idWant;
    }

    public void setIdWant(String idWant) {
        this.idWant = idWant;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getWishPrice() {
        return wishPrice;
    }

    public void setWishPrice(Double wishPrice) {
        this.wishPrice = wishPrice;
    }

    public Double getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(Double fromPrice) {
        this.fromPrice = fromPrice;
    }

    public Boolean getMailAlert() {
        return mailAlert;
    }

    public void setMailAlert(Boolean mailAlert) {
        this.mailAlert = mailAlert;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getIdMetaproduct() {
        return idMetaproduct;
    }

    public void setIdMetaproduct(Integer idMetaproduct) {
        this.idMetaproduct = idMetaproduct;
    }

    public MetaProduct getMetaproduct() {
        return metaproduct;
    }

    public void setMetaproduct(MetaProduct metaproduct) {
        this.metaproduct = metaproduct;
    }

    public List<Integer> getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(List<Integer> idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getMinCondition() {
        return minCondition;
    }

    public void setMinCondition(String minCondition) {
        this.minCondition = minCondition;
    }

    public Boolean getFoil() {
        return isFoil;
    }

    public void setFoil(Boolean foil) {
        isFoil = foil;
    }

    public Boolean getSigned() {
        return isSigned;
    }

    public void setSigned(Boolean signed) {
        isSigned = signed;
    }

    public Boolean getAltered() {
        return isAltered;
    }

    public void setAltered(Boolean altered) {
        isAltered = altered;
    }

    public Boolean getFirstEd() {
        return isFirstEd;
    }

    public void setFirstEd(Boolean firstEd) {
        isFirstEd = firstEd;
    }
}
