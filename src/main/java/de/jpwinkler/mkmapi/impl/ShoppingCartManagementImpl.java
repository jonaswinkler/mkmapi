package de.jpwinkler.mkmapi.impl;

import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import de.jpwinkler.mkmapi.model.ShoppingCardEntry;
import de.jpwinkler.mkmapi.ShoppingCartManagement;
import de.jpwinkler.mkmapi.model.ShoppingCart;

import java.util.List;

public class ShoppingCartManagementImpl implements ShoppingCartManagement {

    private MKMApiClientImpl mkmApiClient;

    public ShoppingCartManagementImpl(MKMApiClientImpl mkmApiClient) {
        this.mkmApiClient = mkmApiClient;
    }

    @Override
    public ShoppingCart getShoppingCart() throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("shoppingcart")
                .execute();
        return null;
    }

    @Override
    public void addToShoppingCart(List<ShoppingCardEntry> articles) {
        throw new UnsupportedOperationException();
    }
}
