package de.jpwinkler.mkmapi.impl;

import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import de.jpwinkler.mkmapi.WantsListManagement;
import de.jpwinkler.mkmapi.model.WantsList;
import de.jpwinkler.mkmapi.model.WantsListItem;
import de.jpwinkler.mkmapi.request.CreateWantsListRequest;
import de.jpwinkler.mkmapi.request.WantsListItemsRequest;
import de.jpwinkler.mkmapi.response.WantsListResponse;

import java.util.List;

public class WantsListManagementImpl implements WantsListManagement {

    private MKMApiClientImpl mkmApiClient;

    public WantsListManagementImpl(MKMApiClientImpl mkmApiClient) {
        this.mkmApiClient = mkmApiClient;
    }

    @Override
    public List<WantsList> getWantsLists() throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("wantslist")
                .execute(WantsListResponse.class)
                .getWantslist();
    }

    @Override
    public WantsList createWantsList(String name, int idGame) throws MKMApiClientException {
        WantsListResponse response = mkmApiClient.getRequestBuilder()
                .path("wantslist")
                .requestObject(new CreateWantsListRequest(name, idGame))
                .execute("POST", WantsListResponse.class);

        if (response.getFailed() != null && response.getFailed().getError() != null && !response.getFailed().getError().isEmpty()) {
            throw new MKMApiClientException(response.getFailed().getError());
        }
        if (response.getWantslist().size() == 1) {
            return response.getWantslist().get(0);
        } else {
            throw new MKMApiClientException("Invalid response");
        }
    }

    @Override
    public WantsList getWantsList(int idWantsList) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("wantslist")
                .path(idWantsList)
                .execute(WantsListResponse.class).getWantslist().get(0);
    }

    @Override
    public void changeWantsListName(int idWantsList, String newName) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("wantslist")
                .path(idWantsList)
                .requestObject(new WantsListItemsRequest("editWantslist", newName))
                .execute("PUT");
    }

    @Override
    public void addWantsListItems(int idWantsList, List<WantsListItem> products, List<WantsListItem> metaProducts) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("wantslist")
                .path(idWantsList)
                .requestObject(new WantsListItemsRequest("addItem", products, metaProducts))
                .execute("PUT");
    }

    @Override
    public void editWantsListItem(int idWantsList, List<WantsListItem> items) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("wantslist")
                .path(idWantsList)
                .requestObject(new WantsListItemsRequest("editItem", items))
                .execute("PUT");
    }

    @Override
    public void deleteWantsListItem(int idWantsList, List<WantsListItem> items) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("wantslist")
                .path(idWantsList)
                .requestObject(new WantsListItemsRequest("deleteItem", items))
                .execute("PUT");
    }

    @Override
    public void deleteWantsList(int idWantsList) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("wantslist")
                .path(idWantsList)
                .execute("DELETE");
    }
}
