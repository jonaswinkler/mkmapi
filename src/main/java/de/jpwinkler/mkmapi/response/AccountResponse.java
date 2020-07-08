package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.Account;
import de.jpwinkler.mkmapi.model.Link;
import de.jpwinkler.mkmapi.model.LinkedObject;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class AccountResponse extends LinkedObject {

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
