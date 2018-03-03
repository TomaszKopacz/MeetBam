package tomaszkopacz.meetbam.model;

/**
 * Created by tomas on 03.03.2018.
 * Post uploaded by user.
 */

public class Post {

    private String name;
    private String surname;

    public Post (){
        this.name = "Tomasz";
        this.surname = "Kopacz";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
