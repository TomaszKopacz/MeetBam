package tomaszkopacz.meetbam.model;

/**
 * Created by tomas on 07.04.2018.
 */

public class UserResult {

    private String name;
    private String surname;
    private String result;

    public UserResult(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
