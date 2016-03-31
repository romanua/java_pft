package addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;;
    private String firstName;
    private String lastName;
    private String group;
//    private String bDay;
//    private String bMonth;
//    private String aDay;
//    private String aMonth;
//    private String nickname;
//    private String companyTitle;
//    private String companyName;
//    private String address;
//    private String homePhone;
//    private String mobilePhone;
//    private String firstEmail;
//    private String birthdayYear;
//    private String anniversaryYear;
//    private String secondAddress;
//    private String notes;



    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

//    public ContactData withtbDay(String bDay) {
//        this.bDay = bDay;
//        return this;
//    }
//
//    public ContactData withbMonth(String bMonth) {
//        this.bMonth = bMonth;
//        return this;
//    }
//
//    public ContactData withaDay(String aDay) {
//        this.aDay = aDay;
//        return this;
//    }
//
//    public ContactData withaMonth(String aMonth) {
//        this.aMonth = aMonth;
//        return this;
//    }
//
//    public ContactData withNickname(String nickname) {
//        this.nickname = nickname;
//        return this;
//    }
//
//    public ContactData withCompanyTitle(String companyTitle) {
//        this.companyTitle = companyTitle;
//        return this;
//    }
//
//    public ContactData withCompanyName(String companyName) {
//        this.companyName = companyName;
//        return this;
//    }
//
//    public ContactData withAddress(String address) {
//        this.address = address;
//        return this;
//    }
//
//    public ContactData withHomePhone(String homePhone) {
//        this.homePhone = homePhone;
//        return this;
//    }
//
//    public ContactData withMobilePhone(String mobilePhone) {
//        this.mobilePhone = mobilePhone;
//        return this;
//    }
//
//    public ContactData withFirstEmail(String firstEmail) {
//        this.firstEmail = firstEmail;
//        return this;
//    }
//
//    public ContactData withBirthdayYear(String birthdayYear) {
//        this.birthdayYear = birthdayYear;
//        return this;
//    }
//
//    public ContactData withAnniversaryYear(String anniversaryYear) {
//        this.anniversaryYear = anniversaryYear;
//        return this;
//    }
//
//    public ContactData withSecondAddress(String secondAddress) {
//        this.secondAddress = secondAddress;
//        return this;
//    }
//
//    public ContactData withNotes(String notes) {
//        this.notes = notes;
//        return this;
//    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    public String getNickname() {
//        return nickname;
//    }
//
//    public String getCompanyTitle() {
//        return companyTitle;
//    }
//
//    public String getCompanyName() {
//        return companyName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getHomePhone() {
//        return homePhone;
//    }
//
//    public String getMobilePhone() {
//        return mobilePhone;
//    }
//
//    public String getFirstEmail() {
//        return firstEmail;
//    }
//
//    public String getAday() {
//        return aDay;
//    }
//
//    public String getAmonth() {
//        return aMonth;
//    }
//
//    public String getBday() {
//        return bDay;
//    }
//
//    public String getBmonth() {
//        return bMonth;
//    }
//
//    public String getBirthdayYear() {
//        return birthdayYear;
//    }
//
//    public String getAnniversaryYear() {
//        return anniversaryYear;
//    }
//
//    public String getSecondAddress() {
//        return secondAddress;
//    }
//
//    public String getNotes() {
//        return notes;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
