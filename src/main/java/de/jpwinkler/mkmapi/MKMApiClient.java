package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

public interface MKMApiClient {

    AccountManagement getAccountManagement();

    MarketPlaceInformation getMarketPlaceInformation();

    OrderManagement getOrderManagement();

    ShoppingCartManagement getShoppingCartManagement();

    StockManagement getStockManagement();

    WantsListManagement getWantsListManagement();

    int getCurrentRequestMax();

    int getCurrentRequestCount();

    MKMAuth getAuth();

    void setAuth(MKMAuth auth);

    void loadCache(String filename) throws IOException;

    void enableCache(boolean enabled);

    void saveCache() throws IOException;

    void saveCache(String filename) throws IOException;

}
