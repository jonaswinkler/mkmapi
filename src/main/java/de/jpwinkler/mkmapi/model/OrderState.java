package de.jpwinkler.mkmapi.model;

import java.util.Date;

public class OrderState {
    private String state;
    private Date dateBought;
    private Date datePaid;
    private Date dateSent;
    private Date dateReceived;
    private Date dateCancelled;
    private String reason;
    private Integer wasMergedInto;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDateBought() {
        return dateBought;
    }

    public void setDateBought(Date dateBought) {
        this.dateBought = dateBought;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateCancelled() {
        return dateCancelled;
    }

    public void setDateCancelled(Date dateCancelled) {
        this.dateCancelled = dateCancelled;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getWasMergedInto() {
        return wasMergedInto;
    }

    public void setWasMergedInto(Integer wasMergedInto) {
        this.wasMergedInto = wasMergedInto;
    }
}
