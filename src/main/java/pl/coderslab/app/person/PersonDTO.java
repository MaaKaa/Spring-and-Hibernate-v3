package pl.coderslab.app.person;

import java.util.Arrays;

public class PersonDTO {
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private boolean mailingList;
    private String[] programmingSkills;
    private String[] hobbies;

    public PersonDTO() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public String[] getProgrammingSkills() {
        return programmingSkills;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }

    public void setProgrammingSkills(String[] skills) {
        this.programmingSkills = skills;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person's data saved:" +
                "login: " + login +
                ", email: " + email +
                ", first name: " + firstName +
                ", last name: " + lastName +
                ", gender: " + gender  +
                ", country: " + country +
                ", notes: " + notes +
                ", mailing list: " + mailingList +
                ", programming skills: " + Arrays.toString(programmingSkills) +
                ", hobbies:" + Arrays.toString(hobbies);
    }
}
