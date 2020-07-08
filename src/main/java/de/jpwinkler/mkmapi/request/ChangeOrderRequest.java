package de.jpwinkler.mkmapi.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class ChangeOrderRequest {

    private String action;
    private String reason;
    private Boolean relistItems;

    public ChangeOrderRequest() {
    }

    public ChangeOrderRequest(String action, String reason, Boolean relistItems) {
        this.action = action;
        this.reason = reason;
        this.relistItems = relistItems;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getRelistItems() {
        return relistItems;
    }

    public void setRelistItems(Boolean relistItems) {
        this.relistItems = relistItems;
    }
}
