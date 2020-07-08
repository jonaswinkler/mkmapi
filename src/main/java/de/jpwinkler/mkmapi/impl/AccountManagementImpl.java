package de.jpwinkler.mkmapi.impl;

import de.jpwinkler.mkmapi.AccountManagement;
import de.jpwinkler.mkmapi.response.*;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import de.jpwinkler.mkmapi.model.Account;
import de.jpwinkler.mkmapi.model.CodeRedemption;
import de.jpwinkler.mkmapi.model.Message;
import de.jpwinkler.mkmapi.model.MessageThread;
import de.jpwinkler.mkmapi.request.CouponRequest;
import de.jpwinkler.mkmapi.request.MessageRequest;

import java.util.Date;
import java.util.List;

public class AccountManagementImpl implements AccountManagement {

    private MKMApiClientImpl mkmApiClient;

    public AccountManagementImpl(MKMApiClientImpl mkmApiClient) {
        this.mkmApiClient = mkmApiClient;
    }

    @Override
    public Account getAccount() throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("account")
                .execute(AccountResponse.class).getAccount();
    }

    @Override
    public Account changeVacationStatus(boolean onVacation, Boolean cancelOrders, Boolean relistItems) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("account").path("vacation")
                .parameter("onVacation", onVacation)
                .parameter("cancelOrders", cancelOrders)
                .parameter("relistItems", relistItems)
                .requestObject("")
                .execute("PUT", AccountResponse.class).getAccount();
    }

    @Override
    public Account changeDisplayLanguage(int idDisplayLanguage) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("account").path("language")
                .parameter("idDisplayLanguage", idDisplayLanguage)
                .requestObject("")
                .execute("PUT", AccountResponse.class).getAccount();
    }

    @Override
    public List<MessageThread> getMessageThreadOverview() throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("account")
                .path("messages")
                .execute(MessageThreadListResponse.class).getThread();
    }

    @Override
    public MessageThread getMessageThread(int idOtherUser) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("account")
                .path("messages")
                .path(idOtherUser)
                .execute(MessageThreadResponse.class);
    }

    @Override
    public Message getMessage(int idOtherUser, String idMessage) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("account")
                .path("messages")
                .path(idOtherUser)
                .path(idMessage)
                .execute(MessageThreadResponse.class).getMessage().get(0);
    }

    @Override
    public Message sendMessage(int idOtherUser, String message) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("account")
                .path("messages")
                .path(idOtherUser)
                .requestObject(new MessageRequest(message))
                .execute("POST", MessageResponse.class).getMessage().get(0);
    }

    @Override
    public void deleteMessage(int idOtherUser, String idMessage) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("account")
                .path("messages")
                .path(idOtherUser)
                .path(idMessage)
                .execute("DELETE");
    }

    @Override
    public void deleteMessageThread(int idOtherUser) throws MKMApiClientException {
        mkmApiClient.getRequestBuilder()
                .path("account")
                .path("messages")
                .path(idOtherUser)
                .execute("DELETE");
    }

    @Override
    public List<Message> findMessages(Boolean unread, Date startDate, Date endDate) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CodeRedemption> redeemCoupon(List<String> coupons) throws MKMApiClientException {
        return mkmApiClient.getRequestBuilder()
                .path("account")
                .path("coupon")
                .requestObject(new CouponRequest(coupons))
                .execute("POST", CodeRedemptionResponse.class).getCoupon();
    }

    @Override
    public void requestSellerActivation(String phoneNumber, String bankAccountOwner, String iban, String bic, String bankName) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void completeSellerActivation(double amount1, double amount2) throws MKMApiClientException {
        throw new UnsupportedOperationException();
    }
}
