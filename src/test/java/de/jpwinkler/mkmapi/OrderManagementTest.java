package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.Order;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import org.junit.Test;

import java.util.List;

public class OrderManagementTest extends MKMApiTest {

    @Test
    public void testGetOrder() throws MKMApiClientException {
        Order order = getClient().getOrderManagement().getOrder(65226590);

        System.out.println(order.getArticleCount());
    }

    @Test
    public void testFilterOrders() throws MKMApiClientException {
        List<Order> orders = getClient().getOrderManagement().filterOrder("buyer", "paid", 1);
    }
}
