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
        type(By.name("email"), contactData.getFirstEmail());
        type(By.name("email2"), contactData.getSecondEmail());
        type(By.name("email3"), contactData.getThirdEmail());
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

    public void initContactModificationByID(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='$s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

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
//        selectContactById(contact.getId());
        initContactModificationByID(contact.getId());
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

    private Contacts contactsCache = null;

//    public Contacts all() {
//        if (contactsCache != null) {
//            return new Contacts(contactsCache);
//        }
//
//        contactsCache = new Contacts();
//        List<WebElement> elements = wd.findElements(By.name("entry"));
//        for (WebElement element : elements) {
//            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//            String firstNAme = element.findElement(By.xpath(".//td[3]")).getText();
//            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
//            contactsCache.add(new ContactData().withId(id).withFirstName(firstNAme).withLastName(lastName));
//        }
//        return new Contacts(contactsCache);
//    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Contacts all() {
        if (contactsCache != null) {
            return new Contacts(contactsCache);
        }

        contactsCache = new Contacts();
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = wd.findElements((By.name("entry")));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String[] emails = cells.get(4).getText().split("\n");

            contactsCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withFirstEmail(emails[0])
                    .withSecondEmail(emails[1]).withThirdEmail(emails[2]));
        }
        return new Contacts(contactsCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationByID(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String firstEmail = wd.findElement(By.name("email")).getAttribute("value");
        String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
        String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withFirstEmail(firstEmail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail);
    }
}
