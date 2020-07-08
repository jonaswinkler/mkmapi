package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.LinkedObject;
import de.jpwinkler.mkmapi.model.Order;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class OrderResponse extends LinkedObject {

    private List<Order> order = new ArrayList<>();

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
