package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.Product;
import de.jpwinkler.mkmapi.model.WantsList;
import de.jpwinkler.mkmapi.model.WantsListItem;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class WantsListManagementTest extends MKMApiTest {

    @Test
    public void testGetWantsList() throws MKMApiClientException {
        List<WantsList> wantsLists = getClient().getWantsListManagement().getWantsLists();
    }

    @Test
    public void testCreateGetDeleteWantsList() throws MKMApiClientException {
        String tempName = "NL" + Long.toString(System.currentTimeMillis()).hashCode();

        List<WantsList> before = getClient().getWantsListManagement().getWantsLists();

        WantsList newList = getClient().getWantsListManagement().createWantsList(tempName, 1);

        WantsList newListAgain = getClient().getWantsListManagement().getWantsList(newList.getIdWantslist());

        List<WantsList> afterCreate = getClient().getWantsListManagement().getWantsLists();

        getClient().getWantsListManagement().deleteWantsList(newList.getIdWantslist());

        List<WantsList> afterDelete = getClient().getWantsListManagement().getWantsLists();

        assertEquals(before.size() + 1, afterCreate.size());
        assertEquals(1, newList.getGame().getIdGame());
        assertEquals(0, newList.getItem().size());
        assertEquals(tempName, newList.getName());
        assertEquals(before.size(), afterDelete.size());
        assertEquals(newList.getIdWantslist(), newListAgain.getIdWantslist());
        assertEquals(newList.getName(), newListAgain.getName());

        try {
            getClient().getWantsListManagement().getWantsList(1);
            fail();
        } catch (MKMApiClientException e) {
            //this is expected to happen.
        }
    }

    @Test
    public void testEditWantsList() throws MKMApiClientException {
        String tempName1 = "A" + Long.toString(System.currentTimeMillis()).hashCode();
        String tempName2 = "B" + Long.toString(System.currentTimeMillis()).hashCode();

        WantsList beforeChange = getClient().getWantsListManagement().createWantsList(tempName1, 1);

        int id = beforeChange.getIdWantslist();

        assertEquals(tempName1, beforeChange.getName());

        getClient().getWantsListManagement().changeWantsListName(id, tempName2);
        WantsList afterNameChange = getClient().getWantsListManagement().getWantsList(id);
        assertEquals(tempName2, afterNameChange.getName());

        List<Product> teferis = getClient().getMarketPlaceInformation().findProduct("Moat", true, 1, 1, null, null);

        List<WantsListItem> itemsToAdd = teferis.stream().filter(p -> p.getCategoryName().equals("Magic Single")).map(p -> {
            WantsListItem item = new WantsListItem();
            item.setIdProduct(p.getIdProduct());
            item.setCount(1);
            item.setMinCondition("EX");
            item.setWishPrice(0.0);
            item.setMailAlert(false);
            return item;
        }).collect(Collectors.toList());

        getClient().getWantsListManagement().addWantsListItems(id, itemsToAdd, null);

        WantsList afterItemsAdd = getClient().getWantsListManagement().getWantsList(id);
        assertEquals(itemsToAdd.size(), afterItemsAdd.getItem().size());

        WantsListItem wantsListItem = afterItemsAdd.getItem().get(0);
        wantsListItem.setWishPrice(10.01);
        wantsListItem.setMinCondition("NM");
        wantsListItem.setMailAlert(true);
        wantsListItem.setFoil(true);

        getClient().getWantsListManagement().editWantsListItem(id, Arrays.asList(wantsListItem));

        WantsList afterItemsEdit = getClient().getWantsListManagement().getWantsList(id);
        WantsListItem editedWantsListItem = afterItemsEdit.getItem().get(0);

        assertEquals(wantsListItem.getIdWant(), editedWantsListItem.getIdWant());
        assertEquals(wantsListItem.getWishPrice(), editedWantsListItem.getWishPrice());

        getClient().getWantsListManagement().deleteWantsList(id);
    }
}
