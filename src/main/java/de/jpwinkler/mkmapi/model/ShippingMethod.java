package de.jpwinkler.mkmapi.model;

public class ShippingMethod {
    private int idShippingMethod;
    private String name;
    private double price;
    private boolean isLetter;
    private boolean isInsured;

    public int getIdShippingMethod() {
        return idShippingMethod;
    }

    public void setIdShippingMethod(int idShippingMethod) {
        this.idShippingMethod = idShippingMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isLetter() {
        return isLetter;
    }

    public void setLetter(boolean letter) {
        isLetter = letter;
    }

    public boolean isInsured() {
        return isInsured;
    }

    public void setInsured(boolean insured) {
        isInsured = insured;
    }
}
