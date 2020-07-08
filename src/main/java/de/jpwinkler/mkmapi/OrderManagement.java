package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.Order;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;

import java.util.List;

public interface OrderManagement {

    Order getOrder(int idOrder) throws MKMApiClientException;

    void changeOrderState(int idOrder, String action, String reason, Boolean relistItems) throws MKMApiClientException;

    void provideTrackingNumber(int idOrder, String trackingNumber) throws MKMApiClientException;

    void evaluateOrder(int idOrder, int evaluationGrade, int itemDescription, int packaging, String comment, List<String> complaint) throws MKMApiClientException;

    List<Order> filterOrder(String actor, String state, Integer start) throws MKMApiClientException;

}
