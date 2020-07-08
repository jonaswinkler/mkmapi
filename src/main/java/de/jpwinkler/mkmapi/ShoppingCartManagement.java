package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.ShoppingCardEntry;
import de.jpwinkler.mkmapi.model.ShoppingCart;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;

import java.util.List;

public interface ShoppingCartManagement {

    ShoppingCart getShoppingCart() throws MKMApiClientException;

    void addToShoppingCart(List<ShoppingCardEntry> articles);

}
