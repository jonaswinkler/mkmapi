package de.jpwinkler.mkmapi.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * https://api.cardmarket.com/ws/documentation/API_2.0:Entities:Account
 */
@XmlRootElement
public class Account {

    private int idUser;
    private String username;
    private String country;
    private int isCommercial;
    private boolean maySell;
    private int sellerActivation;
    private int riskGroup;
    private int reputation;
    private int shipsFast;
    private int sellCount;
    private int soldItems;
    private int avgShippingTime;
    private boolean onVacation;
    private int idDisplayLanguage;
    private Name name = new Name();
    private Address homeAddress = new Address();
    private String email;
    private String phoneNumber;
    private String vat;
    private Date registerDate;
    private MoneyDetails moneyDetails = new MoneyDetails();
    private BankAccount bankAccount = new BankAccount();
    private int articlesInShoppingCart;
    private int unreadMessages;
    private String lossPercentage;
    private String legalInformation;
    private boolean isActivated;

    //TODO: links


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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getIsCommercial() {
        return isCommercial;
    }

    public void setIsCommercial(int isCommercial) {
        this.isCommercial = isCommercial;
    }

    public boolean isMaySell() {
        return maySell;
    }

    public void setMaySell(boolean maySell) {
        this.maySell = maySell;
    }

    public int getSellerActivation() {
        return sellerActivation;
    }

    public void setSellerActivation(int sellerActivation) {
        this.sellerActivation = sellerActivation;
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

    public int getIdDisplayLanguage() {
        return idDisplayLanguage;
    }

    public void setIdDisplayLanguage(int idDisplayLanguage) {
        this.idDisplayLanguage = idDisplayLanguage;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public MoneyDetails getMoneyDetails() {
        return moneyDetails;
    }

    public void setMoneyDetails(MoneyDetails moneyDetails) {
        this.moneyDetails = moneyDetails;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getArticlesInShoppingCart() {
        return articlesInShoppingCart;
    }

    public void setArticlesInShoppingCart(int articlesInShoppingCart) {
        this.articlesInShoppingCart = articlesInShoppingCart;
    }

    public int getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(int unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    public String getLossPercentage() {
        return lossPercentage;
    }

    public void setLossPercentage(String lossPercentage) {
        this.lossPercentage = lossPercentage;
    }

    public String getLegalInformation() {
        return legalInformation;
    }

    public void setLegalInformation(String legalInformation) {
        this.legalInformation = legalInformation;
    }

    @XmlElement(name = "isActivated")
    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }
}
