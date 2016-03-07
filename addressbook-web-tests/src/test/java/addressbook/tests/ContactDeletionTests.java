package addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by roman on 07.03.2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getContactHelper().checkFirstContactFromList();
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().confirmContactDeletion();
    }
}
