package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by roman on 04.04.2016.
 */
public class ContactEmailTests extends TestBase{

    @Test
    public void testContactEmails() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getFirstEmail(), equalTo(contactInfoFromEditForm.getFirstEmail()));
        assertThat(contact.getSecondEmail(), equalTo(contactInfoFromEditForm.getSecondEmail()));
        assertThat(contact.getThirdEmail(), equalTo(contactInfoFromEditForm.getThirdEmail()));

    }
}
