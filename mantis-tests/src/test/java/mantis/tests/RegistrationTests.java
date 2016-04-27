package mantis.tests;

import org.testng.annotations.Test;

import static mantis.tests.TestBase.app;

/**
 * Created by roman on 26.04.2016.
 */
public class RegistrationTests extends TestBase{

    @Test
    public void testRegistration() {
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
