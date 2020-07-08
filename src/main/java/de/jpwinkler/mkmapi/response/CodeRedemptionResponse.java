package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.Account;
import de.jpwinkler.mkmapi.model.CodeRedemption;
import de.jpwinkler.mkmapi.model.LinkedObject;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class CodeRedemptionResponse extends LinkedObject {

    private Account account;
    private List<CodeRedemption> coupon = new ArrayList<>();

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<CodeRedemption> getCoupon() {
        return coupon;
    }

    public void setCoupon(List<CodeRedemption> coupon) {
        this.coupon = coupon;
    }
}
