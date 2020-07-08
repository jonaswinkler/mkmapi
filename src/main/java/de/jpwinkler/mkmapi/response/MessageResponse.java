package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.Message;
import de.jpwinkler.mkmapi.model.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class MessageResponse {

    private User partner;
    private List<Message> message = new ArrayList<>();

    public User getPartner() {
        return partner;
    }

    public void setPartner(User partner) {
        this.partner = partner;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
