package tomaszkopacz.meetbam.model;

/**
 * Created by tomas on 05.03.2018.
 */

public class User {

    private String mail;
    private String password;
    private String name;
    private String surname;

    public User(){

    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
