package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.MetaProduct;
import de.jpwinkler.mkmapi.model.Product;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import org.junit.Test;

import java.util.List;

public class MarketPlaceInformationTest extends MKMApiTest {

    @Test
    public void testGetProductList() throws MKMApiClientException {
        String productListBase64 = getClient().getMarketPlaceInformation().getProductListFile();
    }

    @Test
    public void testFindProduct() throws MKMApiClientException {
        List<Product> karn = getClient().getMarketPlaceInformation().findProduct("Karn", null, null, null, null, null);
    }

    @Test
    public void testGetMetaProduct() throws MKMApiClientException {
        MetaProduct metaProduct = getClient().getMarketPlaceInformation().getMetaProduct(9074);
    }

    @Test
    public void testFindMetaProduct() throws MKMApiClientException {
        List<MetaProduct> schwarzes = getClient().getMarketPlaceInformation().findMetaProduct("Schwarzes", false, 3, 3);
    }

}
