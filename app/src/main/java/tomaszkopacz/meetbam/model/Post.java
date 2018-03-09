package tomaszkopacz.meetbam.model;

/**
 * Created by tomas on 03.03.2018.
 * Post uploaded by user.
 */

public class Post {

    private String id;
    private String user_id;
    private String photo_dir;
    private String time;
    private String name;
    private String surname;

    public Post (){

    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return user_id;
    }

    public String getPhotoDir() {
        return photo_dir;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public void setPhotoDir(String photo_dir) {
        this.photo_dir = photo_dir;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
