package addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;;
    private String firstName;
    private String lastName;
    private String group;
    private String firstEmail;
    private String secondEmail;
    private String thirdEmail;
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
//    private String birthdayYear;
//    private String anniversaryYear;
//    private String secondAddress;
//    private String notes;



    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group='" + group + '\'' +
                ", firstEmail='" + firstEmail + '\'' +
                ", secondEmail='" + secondEmail + '\'' +
                ", thirdEmail='" + thirdEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (firstEmail != null ? !firstEmail.equals(that.firstEmail) : that.firstEmail != null) return false;
        if (secondEmail != null ? !secondEmail.equals(that.secondEmail) : that.secondEmail != null) return false;
        return thirdEmail != null ? thirdEmail.equals(that.thirdEmail) : that.thirdEmail == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (firstEmail != null ? firstEmail.hashCode() : 0);
        result = 31 * result + (secondEmail != null ? secondEmail.hashCode() : 0);
        result = 31 * result + (thirdEmail != null ? thirdEmail.hashCode() : 0);
        return result;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
        return this;
    }

    public ContactData withSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
        return this;
    }

    public ContactData withThirdEmail(String thirdEmail) {
        this.thirdEmail = thirdEmail;
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

    public String getFirstEmail() {
        return firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getThirdEmail() {
        return thirdEmail;
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
//
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


}
