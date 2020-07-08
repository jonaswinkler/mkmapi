package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import org.junit.Test;

public class ShoppingCardManagementTest extends MKMApiTest {

    @Test
    public void testGetShoppingCart() throws MKMApiClientException {
        getClient().getShoppingCartManagement().getShoppingCart();
    }
}
