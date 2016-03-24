package addressbook.model;

public class ContactData {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String bDay;
    private final String bMonth;
    private final String aDay;
    private final String aMonth;
    private final String nickname;
    private final String companyTitle;
    private final String companyName;
    private final String address;
    private final String homePhone;
    private final String mobilePhone;
    private final String firstEmail;
    private final String birthdayYear;
    private final String anniversaryYear;
    private final String secondAddress;
    private final String notes;
    private String group;


    public ContactData(String id, String firstName, String lastName, String bDay, String aDay, String aMonth, String bMonth, String nickname,
                       String companyTitle, String companyName, String address, String homePhone, String mobilePhone, String firstEmail,
                       String birthdayYear, String anniversaryYear, String secondAddress, String notes, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bDay = bDay;
        this.aDay = aDay ;
        this.aMonth = aMonth;
        this.bMonth = bMonth;
        this.nickname = nickname;
        this.companyTitle = companyTitle;
        this.companyName = companyName;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.firstEmail = firstEmail;
        this.birthdayYear = birthdayYear;
        this.anniversaryYear = anniversaryYear;
        this.secondAddress = secondAddress;
        this.notes = notes;
        this.group = group;
    }

    public ContactData(String firstName, String lastName, String bDay, String aDay, String aMonth, String bMonth, String nickname,
                       String companyTitle, String companyName, String address, String homePhone, String mobilePhone, String firstEmail,
                       String birthdayYear, String anniversaryYear, String secondAddress, String notes, String group) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bDay = bDay;
        this.aDay = aDay ;
        this.aMonth = aMonth;
        this.bMonth = bMonth;
        this.nickname = nickname;
        this.companyTitle = companyTitle;
        this.companyName = companyName;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.firstEmail = firstEmail;
        this.birthdayYear = birthdayYear;
        this.anniversaryYear = anniversaryYear;
        this.secondAddress = secondAddress;
        this.notes = null;
        this.group = null;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
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

    public String getFirstEmail() {
        return firstEmail;
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

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getGroup() {
        return group;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

}
