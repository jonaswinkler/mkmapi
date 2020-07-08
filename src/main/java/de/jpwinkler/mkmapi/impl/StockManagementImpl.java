package de.jpwinkler.mkmapi.impl;

import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import de.jpwinkler.mkmapi.StockManagement;
import de.jpwinkler.mkmapi.model.Article;
import de.jpwinkler.mkmapi.request.ArticleRequest;
import de.jpwinkler.mkmapi.response.ArticleResponse;

import java.util.List;

public class StockManagementImpl implements StockManagement {

    private MKMApiClientImpl mkmApiClient;

    public StockManagementImpl(MKMApiClientImpl mkmApiClient) {
        this.mkmApiClient = mkmApiClient;
    }

    @Override
    public List<Article> getStock(Integer start) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("stock")
                .parameter("start", start)
                .execute(ArticleResponse.class).getArticle();
    }

    @Override
    public void addArticlesToStock(List<Article> articles) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("stock")
                .requestObject(new ArticleRequest(articles))
                .execute("POST");
    }

    @Override
    public void changeArticlesInStock(List<Article> articles) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("stock")
                .requestObject(new ArticleRequest(articles))
                .execute("PUT");
    }

    @Override
    public void deleteArticlesFromStock(List<Article> articles) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getStockFile(Integer idGame, Boolean isSealed, Integer idLanguage) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Article> getStockInShoppingCarts() throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Article getStockArticle(int idArticle) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Article> findStockArticles(String name, int idGame) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }
}
