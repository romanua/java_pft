package addressbook.appmanager;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
//        attach(By.name("photo"), contactData.getPhoto());
        type(By.name("email"), contactData.getEmail());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("address"), contactData.getAddress());
//        select(wd.findElement(By.name("bday")), contactData.getBday());
//        select(wd.findElement(By.name("aday")), contactData.getAday());
//        select(wd.findElement(By.name("amonth")), contactData.getAmonth());
//        select(wd.findElement(By.name("bmonth")), contactData.getBmonth());
//        type(By.name("nickname"), contactData.getNickname());
//        type(By.name("title"), contactData.getCompanyTitle());
//        type(By.name("company"), contactData.getCompanyName());
//        type(By.name("address"), contactData.getAddress());
//        type(By.name("home"), contactData.getFirstEmail());
//        type(By.name("mobile"), contactData.getMobilePhone());
//        type(By.name("byear"), contactData.getBirthdayYear());
//        type(By.name("ayear"), contactData.getAnniversaryYear());
//        type(By.name("address2"), contactData.getSecondAddress());
//        type(By.name("notes"), contactData.getNotes());
//
//        if (creation) {
//            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
//        } else {
//            Assert.assertFalse(isElementPresent(By.name("new_group")));
//        }
    }

    private void select(WebElement selectLocator, String selectValue) {
        new Select(selectLocator).selectByVisibleText(selectValue);
    }


    public void deleteSelectedContact() {
        click(By.xpath(".//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }


    public void submitContactEditing() {
        click(By.name("update"));
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

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home page"));
    }

    public void create(ContactData contact, boolean creation) {
        fillContactForm(contact,creation);
        submitContactCreation();
//        contactsCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModificationByID(contact.getId());
        fillContactForm(contact, false);
        submitContactEditing();
//        contactsCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
//        contactsCache = null;
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

//    private Contacts contactsCache = null;

    public Contacts all() {
//        if (contactsCache != null) {
//            return new Contacts(contactsCache);
//        }

        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements((By.name("entry")));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String allphones = cells.get(5).getText();

             contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
                     .withEmail(email).withAllPhones(allphones).withAddress(address));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationByID(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withEmail(email).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address);
    }

    private void initContactModificationByID(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
