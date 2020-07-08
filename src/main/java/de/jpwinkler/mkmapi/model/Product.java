package de.jpwinkler.mkmapi.model;

import java.util.ArrayList;
import java.util.List;

public class Product extends LinkedObject {
    private int idProduct;
    private int idMetaProduct;
    private int countReprints;
    private String enName;
    private List<LocalizedName> localization = new ArrayList<>();
    private String website;
    private String image;
    private String gameName;
    private String categoryName;
    //TODO: this should be an Expansion object
    private String expansion;
    private int nr;
    private int expIcon;
    private String rarity;
    private PriceGuide priceGuide;
    private List<Product> reprint = new ArrayList<>();

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdMetaProduct() {
        return idMetaProduct;
    }

    public void setIdMetaProduct(int idMetaProduct) {
        this.idMetaProduct = idMetaProduct;
    }

    public int getCountReprints() {
        return countReprints;
    }

    public void setCountReprints(int countReprints) {
        this.countReprints = countReprints;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public List<LocalizedName> getLocalization() {
        return localization;
    }

    public void setLocalization(List<LocalizedName> localization) {
        this.localization = localization;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getExpIcon() {
        return expIcon;
    }

    public void setExpIcon(int expIcon) {
        this.expIcon = expIcon;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public PriceGuide getPriceGuide() {
        return priceGuide;
    }

    public void setPriceGuide(PriceGuide priceGuide) {
        this.priceGuide = priceGuide;
    }

    public List<Product> getReprint() {
        return reprint;
    }

    public void setReprint(List<Product> reprint) {
        this.reprint = reprint;
    }
}
