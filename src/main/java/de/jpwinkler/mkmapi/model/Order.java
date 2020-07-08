package de.jpwinkler.mkmapi.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int idOrder;
    private boolean isBuyer;
    private User seller;
    private User buyer;
    private OrderState state;
    private ShippingMethod shippingMethod;
    private String trackingNumber;
    private String temporaryEmail;
    private boolean isPresale;
    private Address shippingAddress;
    private int articleCount;
    private String note;
    private Evaluation evaluation;
    private List<Article> article = new ArrayList<>();
    private double articleValue;
    private double serviceFeeValue;
    private double totalValue;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @XmlElement(name = "isBuyer")
    public boolean getIsBuyer() {
        return isBuyer;
    }

    public void setIsBuyer(boolean buyer) {
        isBuyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @XmlElement(name = "buyer")
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTemporaryEmail() {
        return temporaryEmail;
    }

    public void setTemporaryEmail(String temporaryEmail) {
        this.temporaryEmail = temporaryEmail;
    }

    @XmlElement(name = "isPresale")
    public boolean getIsPresale() {
        return isPresale;
    }

    public void setIsPresale(boolean presale) {
        isPresale = presale;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    public double getArticleValue() {
        return articleValue;
    }

    public void setArticleValue(double articleValue) {
        this.articleValue = articleValue;
    }

    public double getServiceFeeValue() {
        return serviceFeeValue;
    }

    public void setServiceFeeValue(double serviceFeeValue) {
        this.serviceFeeValue = serviceFeeValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
