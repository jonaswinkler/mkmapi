package de.jpwinkler.mkmapi.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class Article extends LinkedObject {
    private int idArticle;
    private int idProduct;
    private Language language;
    private String comments;
    private double price;
    private int count;
    private boolean inShoppingCart;
    private Product product;
    private User seller;
    private Date lastEdited;
    private String condition;
    private boolean isFoil;
    private boolean isSigned;
    private boolean isAltered;
    private boolean isPlayset;

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isInShoppingCart() {
        return inShoppingCart;
    }

    public void setInShoppingCart(boolean inShoppingCart) {
        this.inShoppingCart = inShoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @XmlElement(name = "isFoil")
    public boolean isFoil() {
        return isFoil;
    }

    public void setFoil(boolean foil) {
        isFoil = foil;
    }

    @XmlElement(name = "isSigned")
    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    @XmlElement(name = "isAltered")
    public boolean isAltered() {
        return isAltered;
    }

    public void setAltered(boolean altered) {
        isAltered = altered;
    }

    @XmlElement(name = "isPlayset")
    public boolean isPlayset() {
        return isPlayset;
    }

    public void setPlayset(boolean playset) {
        isPlayset = playset;
    }
}
