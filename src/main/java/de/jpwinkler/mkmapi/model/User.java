package de.jpwinkler.mkmapi.model;

import java.util.Date;

public class User {

    private int idUser;
    private String username;
    private Date registrationDate;
    private int isCommercial;
    private boolean isSeller;
    private Name name = new Name();
    private Address address = new Address();
    private String phone;
    private String email;
    private String vat;
    private String legalInformation;
    private int riskGroup;
    private String lossPercentage;
    private int unsentShipments;
    private int reputation;
    private int shipsFast;
    private int sellCount;
    private int soldItems;
    private int avgShippingTime;
    private boolean onVacation;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getIsCommercial() {
        return isCommercial;
    }

    public void setIsCommercial(int isCommercial) {
        this.isCommercial = isCommercial;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getLegalInformation() {
        return legalInformation;
    }

    public void setLegalInformation(String legalInformation) {
        this.legalInformation = legalInformation;
    }

    public int getRiskGroup() {
        return riskGroup;
    }

    public void setRiskGroup(int riskGroup) {
        this.riskGroup = riskGroup;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public String getLossPercentage() {
        return lossPercentage;
    }

    public void setLossPercentage(String lossPercentage) {
        this.lossPercentage = lossPercentage;
    }

    public int getUnsentShipments() {
        return unsentShipments;
    }

    public void setUnsentShipments(int unsentShipments) {
        this.unsentShipments = unsentShipments;
    }

    public int getShipsFast() {
        return shipsFast;
    }

    public void setShipsFast(int shipsFast) {
        this.shipsFast = shipsFast;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public int getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(int soldItems) {
        this.soldItems = soldItems;
    }

    public int getAvgShippingTime() {
        return avgShippingTime;
    }

    public void setAvgShippingTime(int avgShippingTime) {
        this.avgShippingTime = avgShippingTime;
    }

    public boolean isOnVacation() {
        return onVacation;
    }

    public void setOnVacation(boolean onVacation) {
        this.onVacation = onVacation;
    }
}
