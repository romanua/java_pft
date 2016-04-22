package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by roman on 07.03.2016.
 */
public class  ContactModificationTests extends TestBase {

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
    public void testContactModificationTest() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Ivan").withLastName("Ivanov").withMobilePhone("333")
                .withEmail("email@gmail.com").withAddress("address");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
