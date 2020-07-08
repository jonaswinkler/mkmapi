package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.*;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;

import java.util.List;

public interface MarketPlaceInformation {

    List<Game> getGames() throws MKMApiClientException;

    List<Expansion> getExpansions(int idGame) throws MKMApiClientException;

    List<Product> getExpansionSingles(int idExpansion) throws MKMApiClientException;

    Product getProduct(int idProduct) throws MKMApiClientException;

    String getProductListFile() throws MKMApiClientException;

    List<Product> findProduct(String search, Boolean exact, Integer idGame, Integer idLanguage, Integer start, Integer maxResults) throws MKMApiClientException;

    List<Article> getArticles(int idProduct, Integer start, Integer maxResults, String userType, Integer minUserScore, Integer idLanguage, String minCondition, Boolean isFoil, Boolean isSigned, Boolean isAltered, Integer minAvailable) throws MKMApiClientException;

    MetaProduct getMetaProduct(int idMetaproduct) throws MKMApiClientException;

    List<MetaProduct> findMetaProduct(String search, Boolean exact, Integer idGame, Integer idLanguage) throws MKMApiClientException;

    User getUser(int idUser) throws MKMApiClientException;

    User getUser(String username) throws MKMApiClientException;

    List<User> findUsers(String search) throws MKMApiClientException;

    List<Article> getUserArticles(int idUser, Integer idGame, Integer start, Integer maxResults) throws MKMApiClientException;

    List<Article> getUserArticles(String idUser, Integer idGame, Integer start, Integer maxResults) throws MKMApiClientException;

}
