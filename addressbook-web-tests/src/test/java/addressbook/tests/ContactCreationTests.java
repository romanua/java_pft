package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().contactCreation(new ContactData("1", "June", "7", "July", "firstName", "middleName", "lastName", "nickname", "title", "company", "address",
                "777777", "777777", "777777", "777777", "email2@com", "email3@com", "www.homepage.com", "1977", "1997", "secondary address", "home", "notes", "test1"), true);
        app.getNavigationHelper().returnToHomePage();
    }

}
