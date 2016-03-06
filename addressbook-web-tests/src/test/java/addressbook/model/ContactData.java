package addressbook.model;

public class ContactData {
    private final String bDay;
    private final String bMonth;
    private final String aDay;
    private final String aMonth;
    private final String name;
    private final String middleName;
    private final String lastName;
    private final String nickname;
    private final String companyTitle;
    private final String companyName;
    private final String address;
    private final String homePhone;
    private final String mobilePhone;
    private final String workPhone;
    private final String fax;
    private final String firstEmail;
    private final String secondEmail;
    private final String website;
    private final String birthdayYear;
    private final String anniversaryYear;
    private final String secondAddress;
    private final String phone;
    private final String notes;


    public ContactData(String bDay, String bMonth, String aDay, String aMonth, String name, String middleName, String lastName, String nickname, String companyTitle, String companyName, String address, String homePhone, String mobilePhone, String workPhone, String fax, String firstEmail, String secondEmail, String website, String birthdayYear, String anniversaryYear, String secondAddress, String phone, String notes) {
        this.aDay = aDay;
        this.bDay = bDay;
        this.aMonth = aMonth;
        this.bMonth = bMonth;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.companyTitle = companyTitle;
        this.companyName = companyName;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.website = website;
        this.birthdayYear = birthdayYear;
        this.anniversaryYear = anniversaryYear;
        this.secondAddress = secondAddress;
        this.phone = phone;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFax() {
        return fax;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getWebsite() {
        return website;
    }

    public String getAday() {
        return aDay;
    }

    public String getAmonth() {
        return aMonth;
    }

    public String getBday() {
        return bDay;
    }

    public String getBmonth() {
        return bMonth;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public String getAnniversaryYear() {
        return anniversaryYear;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getNotes() {
        return notes;
    }
}
