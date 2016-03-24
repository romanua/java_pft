package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("firstName", "middleName", "1", "7", "June", "July", "lastName", "title", "company", "address",
                "777777", "777777", "777777", "777777", "email2@com", "email3@com", "test", "group3");
        app.getContactHelper().contactCreation(contact, true);
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();


        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
