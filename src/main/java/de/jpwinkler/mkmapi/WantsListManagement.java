package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.WantsList;
import de.jpwinkler.mkmapi.model.WantsListItem;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;

import java.util.List;

public interface WantsListManagement {

    List<WantsList> getWantsLists() throws MKMApiClientException;

    WantsList createWantsList(String name, int idGame) throws MKMApiClientException;

    WantsList getWantsList(int idWantsList) throws MKMApiClientException;

    void changeWantsListName(int idWantsList, String newName) throws MKMApiClientException;

    void addWantsListItems(int idWantsList, List<WantsListItem> products, List<WantsListItem> metaProducts) throws MKMApiClientException;

    void editWantsListItem(int idWantsList, List<WantsListItem> items) throws MKMApiClientException;

    void deleteWantsListItem(int idWantsList, List<WantsListItem> items) throws MKMApiClientException;

    void deleteWantsList(int idWantsList) throws MKMApiClientException;

}
