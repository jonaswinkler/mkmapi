package de.jpwinkler.mkmapi.impl;

import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import de.jpwinkler.mkmapi.OrderManagement;
import de.jpwinkler.mkmapi.model.Order;
import de.jpwinkler.mkmapi.request.ChangeOrderRequest;
import de.jpwinkler.mkmapi.response.OrderResponse;

import java.util.List;

public class OrderManagementImpl implements OrderManagement {

    private MKMApiClientImpl mkmApiClient;

    public OrderManagementImpl(MKMApiClientImpl mkmApiClient) {
        this.mkmApiClient = mkmApiClient;
    }

    @Override
    public Order getOrder(int idOrder) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("order")
                .path(idOrder)
                .execute(OrderResponse.class).getOrder().get(0);
    }

    @Override
    public void changeOrderState(int idOrder, String action, String reason, Boolean relistItems) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("order")
                .path(idOrder)
                .requestObject(new ChangeOrderRequest(action, reason, relistItems))
                .execute("PUT");
    }

    @Override
    public void provideTrackingNumber(int idOrder, String trackingNumber) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void evaluateOrder(int idOrder, int evaluationGrade, int itemDescription, int packaging, String comment, List<String> complaint) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Order> filterOrder(String actor, String state, Integer start) throws MKMApiClientException {
        MKMApiClientImpl.RequestBuilder builder = mkmApiClient.getRequestBuilder()
                .path("orders")
                .path(actor)
                .path(state);

        if (start != null) {
            builder = builder.path(start);
        }

        return builder
                .withCache(60*60)
                .execute(OrderResponse.class).getOrder();
    }
}
