package de.jpwinkler.mkmapi.impl;

import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import de.jpwinkler.mkmapi.MarketPlaceInformation;
import de.jpwinkler.mkmapi.response.*;
import de.jpwinkler.mkmapi.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class MarketPlaceInformationImpl implements MarketPlaceInformation {

    private MKMApiClientImpl mkmApiClient;

    public MarketPlaceInformationImpl(MKMApiClientImpl mkmApiClient) {
        this.mkmApiClient = mkmApiClient;
    }

    @Override
    public List<Game> getGames() throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("games")
                .execute(GameResponse.class).getGame();
    }

    @Override
    public List<Expansion> getExpansions(int idGame) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("games")
                .path(idGame)
                .path("expansions")
                .execute(ExpansionResponse.class).getExpansion();
    }

    @Override
    public List<Product> getExpansionSingles(int idExpansion) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("expansions")
                .path(idExpansion)
                .path("singles")
                .execute(SinglesResponse.class).getSingle();
    }

    @Override
    public Product getProduct(int idProduct) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("products")
                .path(idProduct)
                .withCache(3600 * 24 * 7)
                .execute(ProductResponse.class).getProduct().get(0);
    }

    @Override
    public String getProductListFile() throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("productlist")
                .withCache(3600 * 24 * 7)
                .execute(ProductListResponse.class).getProductsfile();
    }

    @Override
    public List<Product> findProduct(String search, Boolean exact, Integer idGame, Integer idLanguage, Integer start, Integer maxResults) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("products")
                .path("find")
                .parameter("search", search)
                .parameter("exact", exact)
                .parameter("idGame", idGame)
                .parameter("idLanguage", idLanguage)
                .parameter("start", start)
                .parameter("maxResults", maxResults)
                .execute(ProductResponse.class).getProduct();
    }

    @Override
    public List<Article> getArticles(int idProduct, Integer start, Integer maxResults, String userType, Integer minUserScore, Integer idLanguage, String minCondition, Boolean isFoil, Boolean isSigned, Boolean isAltered, Integer minAvailable) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("articles")
                .path(idProduct)
                .parameter("start", start)
                .parameter("maxResults", maxResults)
                .parameter("userType", userType)
                .parameter("minUserScore", minUserScore)
                .parameter("idLanguage", idLanguage)
                .parameter("minCondition", minCondition)
                .parameter("isFoil", isFoil)
                .parameter("isSigned", isSigned)
                .parameter("isAltered", isAltered)
                .parameter("minAvailable", minAvailable)
                .parameter("sellerCountry", "D")
                .withCache(3600 * 24) // full day
                .execute(ArticleResponse.class).getArticle();

    }

    @Override
    public MetaProduct getMetaProduct(int idMetaproduct) throws MKMApiClientException {
        MetaProductResponse response = mkmApiClient.getRequestBuilder()
                .path("metaproducts")
                .path(idMetaproduct)
                .execute(MetaProductResponse.class);
        response.getMetaProduct().setProduct(response.getProduct());
        return response.getMetaProduct();
    }

    @Override
    public List<MetaProduct> findMetaProduct(String search, Boolean exact, Integer idGame, Integer idLanguage) throws MKMApiClientException {
        MetaProductListResponse response = mkmApiClient.getRequestBuilder()
                .path("metaproducts")
                .path("find")
                .parameter("search", search)
                .parameter("exact", exact)
                .parameter("idGame", idGame)
                .parameter("idLanguage", idLanguage)
                .execute(MetaProductListResponse.class);

        response.getMetaproduct().forEach(o -> o.getMetaproduct().setProduct(o.getProduct()));
        return response.getMetaproduct().stream().map(o -> o.getMetaproduct()).collect(Collectors.toList());
    }

    @Override
    public User getUser(int idUser) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User getUser(String username) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findUsers(String search) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Article> getUserArticles(int idUser, Integer idGame, Integer start, Integer maxResults) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Article> getUserArticles(String idUser, Integer idGame, Integer start, Integer maxResults) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }
}
