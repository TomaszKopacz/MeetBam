package tomaszkopacz.meetbam.model;

/**
 * Created by tomas on 03.03.2018.
 * Post uploaded by user.
 */

public class Post {

    private String id = "1";
    private String mail = "my.mail@onet.pl";
    private String photo_dir = "uploads/1";
    private String time = "today";

    public Post (){

    }

    public String getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPhotoDir() {
        return photo_dir;
    }

    public String getTime() {
        return time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoto_dir(String photo_dir) {
        this.photo_dir = photo_dir;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
