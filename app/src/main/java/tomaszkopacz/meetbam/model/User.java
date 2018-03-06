package tomaszkopacz.meetbam.model;

/**
 * Created by tomas on 05.03.2018.
 */

public class User {

    private String id;
    private String name;
    private String surname;
    private String mail;

    public User(){

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }
}
