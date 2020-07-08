package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.LinkedObject;
import de.jpwinkler.mkmapi.model.MessageThread;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class MessageThreadResponse extends MessageThread {
}
