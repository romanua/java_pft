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
        if (app.contact().all().size() == 0) {
            app.contact().gotoContactPage();
            ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Ivanov").withGroup("test1").withFirstEmail("111")
                    .withSecondEmail("222").withThirdEmail("333").withHomePhone("111").withMobilePhone("222").withWorkPhone("333");
            app.contact().create(contact, true);
        }
    }

    @Test
    public void testContactModificationTest() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Ivan").withLastName("Ivanov").withGroup("test1");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
