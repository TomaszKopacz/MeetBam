package tomaszkopacz.meetbam.model;

/**
 * Created by tomas on 03.03.2018.
 * Post uploaded by user.
 */

public class Post {

    private String name;
    private String surname;
    private String text;

    public Post (){
        this.name = "Tomasz";
        this.surname = "Kopacz";
        this.text = "Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum " +
                "Lorem Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum " +
                "Lorem Lorem Ipsum Lorem Ipsum Ipsum Lorem Ipsum Ipsum Lorem Ipsum";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setText(String text) {
        this.text = text;
    }
}
