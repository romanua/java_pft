package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by roman on 07.03.2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion(){
        if (! app.getContactHelper().isContactPresent()) {
            app.getContactHelper().gotoContactPage();
            ContactData contact = new ContactData("firstName", "lastName", "1", "7", "June", "July", "lastName", "title", "company", "address",
                    "777777", "777777", "777777", "777777", "email2@com", "email3@com", "test", "group3");
            app.getContactHelper().contactCreation(contact, true);
            app.getNavigationHelper().gotoHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().checkFirstContactFromList();
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().confirmContactDeletion();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
