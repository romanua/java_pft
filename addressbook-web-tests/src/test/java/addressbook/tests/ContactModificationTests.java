package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Created by roman on 07.03.2016.
 */
public class  ContactModificationTests extends TestBase {

    @Test
    public void testContactModificationTest() {
        if (! app.getContactHelper().isContactPresent()) {
            app.getContactHelper().gotoContactPage();
            ContactData contact = new ContactData("firstName", "middleName", "1", "7", "June", "July", "lastName", "title", "company", "address",
                    "777777", "777777", "777777", "777777", "email2@com", "email3@com", "test", "group3");
            app.getContactHelper().contactCreation(contact, true);
        }
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initEditingFirstContact();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "firstName", "middleName", "1", "7", "June", "July", "lastName", "title", "company", "address",
                "777777", "777777", "777777", "777777", "email2@com", "email3@com", "test", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactEditing();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
