package de.jpwinkler.mkmapi.request;

import de.jpwinkler.mkmapi.model.MetaProduct;
import de.jpwinkler.mkmapi.model.Product;
import de.jpwinkler.mkmapi.model.WantsListItem;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "request")
public class WantsListItemsRequest {

    private String action;
    private String name;
    private List<WantsListItem> product;
    private List<WantsListItem> metaproduct;
    private List<WantsListItem> want;

    public WantsListItemsRequest() {
    }

    public WantsListItemsRequest(String action, String name) {
        this.action = action;
        this.name = name;
    }

    public WantsListItemsRequest(String action, List<WantsListItem> product, List<WantsListItem> metaproduct) {
        this.action = action;
        this.product = product;
        this.metaproduct = metaproduct;
    }

    public WantsListItemsRequest(String action, List<WantsListItem> want) {
        this.action = action;
        this.want = want;
    }

    /**
     * One of editWantslist, addItem, editItem, deleteItem
     * @return
     */
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WantsListItem> getProduct() {
        return product;
    }

    public void setProduct(List<WantsListItem> product) {
        this.product = product;
    }

    public List<WantsListItem> getMetaproduct() {
        return metaproduct;
    }

    public void setMetaproduct(List<WantsListItem> metaproduct) {
        this.metaproduct = metaproduct;
    }

    public List<WantsListItem> getWant() {
        return want;
    }

    public void setWant(List<WantsListItem> want) {
        this.want = want;
    }
}
