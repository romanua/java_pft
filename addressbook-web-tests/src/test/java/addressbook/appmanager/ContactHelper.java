package addressbook.appmanager;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by roman on 06.03.2016.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
//        select(wd.findElement(By.name("bday")), contactData.getBday());
//        select(wd.findElement(By.name("aday")), contactData.getAday());
//        select(wd.findElement(By.name("amonth")), contactData.getAmonth());
//        select(wd.findElement(By.name("bmonth")), contactData.getBmonth());
//        type(By.name("nickname"), contactData.getNickname());
//        type(By.name("title"), contactData.getCompanyTitle());
//        type(By.name("company"), contactData.getCompanyName());
//        type(By.name("address"), contactData.getAddress());
//        type(By.name("home"), contactData.getHomePhone());
//        type(By.name("mobile"), contactData.getMobilePhone());
//        type(By.name("email2"), contactData.getFirstEmail());
//        type(By.name("byear"), contactData.getBirthdayYear());
//        type(By.name("ayear"), contactData.getAnniversaryYear());
//        type(By.name("address2"), contactData.getSecondAddress());
//        type(By.name("notes"), contactData.getNotes());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    private void select(WebElement selectLocator, String selectValue) {
        new Select(selectLocator).selectByVisibleText(selectValue);
    }

    public void checkFirstContactFromList() {
        click(By.xpath(".//tr[@name='entry'][1]//input"));
    }

    public void initContactDeletion() {
        click(By.xpath(".//*[@value='Delete']"));
    }

    public void initEditingFirstContact() {
        click(By.xpath(".//table//tr[2]//img[@title='Edit']"));
    }

    public void submitContactEditing() {
        click(By.name("update"));
    }

    public void confirmContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public boolean isContactPresent() {
        return isElementPresent(By.xpath(".//tr[@name='entry'][1]//input"));
    }

    public void gotoContactPage() {
        if (isElementPresent(By.xpath(".//input[@value='Enter'][1]"))) {
            return;
        }
        click(By.linkText("add new"));
    }

    public void create(ContactData contact, boolean creation) {
        fillContactForm(contact,creation);
        submitContactCreation();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initEditingFirstContact();
        fillContactForm(contact, false);
        submitContactEditing();
    }


    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        initContactDeletion();
        confirmContactDeletion();
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstNAme = element.findElement(By.xpath(".//td[3]")).getText();
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstNAme).withLastName(lastName));
        }
        return contacts;
    }
}
