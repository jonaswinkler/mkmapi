package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.model.Account;
import de.jpwinkler.mkmapi.model.CodeRedemption;
import de.jpwinkler.mkmapi.model.Message;
import de.jpwinkler.mkmapi.model.MessageThread;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AccountManagementTest extends MKMApiTest {


    @Test
    public void testGetAccount() throws MKMApiClientException {
        Account account = getClient().getAccountManagement().getAccount();
    }

    @Test
    public void testVacationStatus() throws MKMApiClientException {
        Account account = getClient().getAccountManagement().getAccount();
        assertFalse(account.isOnVacation());

        getClient().getAccountManagement().changeVacationStatus(true, null, null);

        account = getClient().getAccountManagement().getAccount();
        assertTrue(account.isOnVacation());

        getClient().getAccountManagement().changeVacationStatus(false, null, null);

        account = getClient().getAccountManagement().getAccount();
        assertFalse(account.isOnVacation());
    }

    @Test
    public void testChangeDisplayLanguage() throws MKMApiClientException {
        getClient().getAccountManagement().changeDisplayLanguage(2);
        getClient().getAccountManagement().changeDisplayLanguage(3);
    }

    @Test
    public void testGetSendDeleteMessages() throws MKMApiClientException {
        int idUser = 1066387;

        try {
            //just cleanup before the test.
            getClient().getAccountManagement().deleteMessageThread(idUser);
        } catch (Exception e) {
        }

        List<MessageThread> beforeSend = getClient().getAccountManagement().getMessageThreadOverview();
        Message message1 = getClient().getAccountManagement().sendMessage(idUser, "HI!");

        List<MessageThread> afterSend = getClient().getAccountManagement().getMessageThreadOverview();
        assertEquals(beforeSend.size()+1,afterSend.size());

        Message message1Copy = getClient().getAccountManagement().getMessage(idUser, message1.getIdMessage());
        assertEquals(message1.getIdMessage(), message1Copy.getIdMessage());
        assertEquals(message1.getText(), message1Copy.getText());
        assertEquals(message1.getDate(), message1Copy.getDate());

        MessageThread messageThread = getClient().getAccountManagement().getMessageThread(idUser);
        assertEquals(1, messageThread.getMessage().size());
        assertEquals("HI!", messageThread.getMessage().get(0).getText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message message2 = getClient().getAccountManagement().sendMessage(idUser, "LEA!");
        MessageThread messageThreadAfterSecondSend = getClient().getAccountManagement().getMessageThread(idUser);
        assertEquals(messageThread.getMessage().size() + 1, messageThreadAfterSecondSend.getMessage().size());

        assertEquals(message1.getIdMessage(), messageThreadAfterSecondSend.getMessage().get(1).getIdMessage());
        assertEquals(message2.getIdMessage(), messageThreadAfterSecondSend.getMessage().get(0).getIdMessage());

        getClient().getAccountManagement().deleteMessage(idUser, message2.getIdMessage());

        MessageThread messageThreadAfterDelete = getClient().getAccountManagement().getMessageThread(idUser);
        assertEquals(messageThreadAfterSecondSend.getMessage().size() - 1, messageThreadAfterDelete.getMessage().size());
        assertEquals(message1.getIdMessage(), messageThreadAfterDelete.getMessage().get(0).getIdMessage());

        getClient().getAccountManagement().deleteMessageThread(idUser);

        List<MessageThread> messageThreadOverviewAfterDelete = getClient().getAccountManagement().getMessageThreadOverview();
        assertEquals(afterSend.size()-1,messageThreadOverviewAfterDelete.size());
    }

    @Test
    public void testCodeRedemption() throws MKMApiClientException {
        List<CodeRedemption> codeRedemptions = getClient().getAccountManagement().redeemCoupon(Arrays.asList("c1", "c2"));
        assertEquals(2, codeRedemptions.size());
        assertEquals("c1", codeRedemptions.get(0).getCouponCode());
        assertEquals("c2", codeRedemptions.get(1).getCouponCode());
        assertFalse(codeRedemptions.get(0).isSuccessful());
        assertFalse(codeRedemptions.get(1).isSuccessful());
    }

}
