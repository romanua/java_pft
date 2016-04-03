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
        if (app.contact().all().size() == 0) {
            app.contact().gotoContactPage();
            ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Ivanov").withGroup("test1").withFirstEmail("111").withSecondEmail("222").withThirdEmail("333");
            app.contact().create(contact, true);
        }
    }

    @Test
    public void testContactDeletion(){
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().gotoHomePage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        before.remove(deletedContact);
        assertThat(after, equalTo(before.without(deletedContact)));

    }


}
