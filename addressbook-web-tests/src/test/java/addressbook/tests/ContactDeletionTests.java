package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

/**
 * Created by roman on 07.03.2016.
 */
public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().gotoContactPage();
            ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Ivanov").withEmail("email@gmail.com")
                    .withAddress("address").withHomePhone("111").withMobilePhone("222").withWorkPhone("333");
            app.contact().create(contact, true);
        }
    }

    @Test
    public void testContactDeletion(){
        app.goTo().gotoHomePage();
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().gotoHomePage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
        before.remove(deletedContact);
        assertThat(after, equalTo(before.without(deletedContact)));

    }


}
