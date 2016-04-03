package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        app.contact().gotoContactPage();
        ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Ivanov").withGroup("test1").withFirstEmail("111").withSecondEmail("222").withThirdEmail("333");
        app.contact().create(contact, true);
        app.goTo().returnToHomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadContactCreation() {
        Contacts before = app.contact().all();
        app.contact().gotoContactPage();
        ContactData contact = new ContactData().withFirstName("Ivan").withLastName("Ivanov").withGroup("test1").withFirstEmail("111").withSecondEmail("222").withThirdEmail("333");
        app.contact().create(contact, true);
        app.goTo().returnToHomePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

}
