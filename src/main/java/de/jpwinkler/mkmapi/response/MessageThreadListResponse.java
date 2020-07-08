package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.Link;
import de.jpwinkler.mkmapi.model.LinkedObject;
import de.jpwinkler.mkmapi.model.MessageThread;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class MessageThreadListResponse extends LinkedObject {

    private List<MessageThread> thread = new ArrayList<>();

    public List<MessageThread> getThread() {
        return thread;
    }

    public void setThread(List<MessageThread> thread) {
        this.thread = thread;
    }
}
