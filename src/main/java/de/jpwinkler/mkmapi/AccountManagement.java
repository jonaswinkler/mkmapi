package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.Account;
import de.jpwinkler.mkmapi.model.CodeRedemption;
import de.jpwinkler.mkmapi.model.Message;
import de.jpwinkler.mkmapi.model.MessageThread;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;

import java.util.Date;
import java.util.List;

public interface AccountManagement {

    /**
     * Returns the account details of the authenticated user
     *
     * @return
     * @throws MKMApiClientException
     */
    Account getAccount() throws MKMApiClientException;

    /**
     * Updates the vacation status of the authenticated user; returns the Account entity of the authenticated user
     * @param onVacation Flag if the user is on vacation or not
     * @param cancelOrders Flag to cancel open orders, resp. request cancellation for open orders
     * @param relistItems Flag to relist items for canceled orders; only applies if cancelOrders is also provided and set to true for all orders, that are effectively canceled
     * @throws MKMApiClientException
     */
    Account changeVacationStatus(boolean onVacation, Boolean cancelOrders, Boolean relistItems) throws MKMApiClientException;

    /**
     * 1: English
     * 2: French
     * 3: German
     * 4: Spanish
     * 5: Italian
     * @param idDisplayLanguage
     * @throws MKMApiClientException
     */
    Account changeDisplayLanguage(int idDisplayLanguage) throws MKMApiClientException;

    List<MessageThread> getMessageThreadOverview() throws MKMApiClientException;

    MessageThread getMessageThread(int idOtherUser) throws MKMApiClientException;

    Message getMessage(int idOtherUser, String idMessage) throws MKMApiClientException;

    Message sendMessage(int idOtherUser, String message) throws MKMApiClientException;

    void deleteMessage(int idOtherUser, String idMessage) throws MKMApiClientException;

    void deleteMessageThread(int idOtherUser) throws MKMApiClientException;

    List<Message> findMessages(Boolean unread, Date startDate, Date endDate) throws MKMApiClientException;

    List<CodeRedemption> redeemCoupon(List<String> coupons) throws MKMApiClientException;

    void requestSellerActivation(String phoneNumber, String bankAccountOwner, String iban, String bic, String bankName) throws MKMApiClientException;

    void completeSellerActivation(double amount1, double amount2) throws MKMApiClientException;

}
