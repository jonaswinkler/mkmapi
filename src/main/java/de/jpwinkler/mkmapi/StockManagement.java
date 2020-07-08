package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.Article;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;

import java.util.List;

public interface StockManagement {

    List<Article> getStock(Integer start) throws MKMApiClientException;

    void addArticlesToStock(List<Article> articles) throws MKMApiClientException;

    void changeArticlesInStock(List<Article> articles) throws MKMApiClientException;

    void deleteArticlesFromStock(List<Article> articles) throws MKMApiClientException;

    String getStockFile(Integer idGame, Boolean isSealed, Integer idLanguage) throws MKMApiClientException;

    List<Article> getStockInShoppingCarts() throws MKMApiClientException;

    Article getStockArticle(int idArticle) throws MKMApiClientException;

    List<Article> findStockArticles(String name, int idGame) throws MKMApiClientException;

    //TODO change stock quantity

}
