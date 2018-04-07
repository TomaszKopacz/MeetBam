package tomaszkopacz.meetbam.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/**
 * Created by tomas on 05.04.2018.
 */

public class LoginService {

    private SharedPreferences sharedPreferences;

    private static final String MAIL = "mail";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PASSWORD = "password";
    private static final String NO_USER = "";

    public LoginService(Context context){

        this.sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
    }

    /**
     * Checks, whether any user is logged in.
     * @return
     */
    public boolean isUserLoggedIn(){

        String user = sharedPreferences.getString(MAIL, NO_USER);

        return (!user.equals(NO_USER)) ? true : false;
    }

    /**
     * Returns logged user mail.
     * @return
     */
    public String getUserMail(){
        return sharedPreferences.getString(MAIL, NO_USER);
    }

    /**
     * Returns logged user name.
     * @return
     */
    public String getUserName(){
        return sharedPreferences.getString(NAME, NO_USER);
    }

    /**
     * Returns logged user surname.
     * @return
     */
    public String getUserSurname(){
        return sharedPreferences.getString(SURNAME, NO_USER);
    }

    /**
     * Returns logged user password.
     * @return
     */
    public String getUserPassword(){
        return sharedPreferences.getString(PASSWORD, NO_USER);
    }

    /**
     * Login new user. User is determined by giving his email.
     * @param mail
     */
    public void login(String mail, String name, String surname, String pwd){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MAIL, mail);
        editor.putString(NAME, name);
        editor.putString(SURNAME, surname);
        editor.putString(PASSWORD, pwd);
        editor.commit();
    }

    /**
     * Logout user.
     */
    public void logout(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MAIL);
        editor.remove(NAME);
        editor.remove(SURNAME);
        editor.remove(PASSWORD);
        editor.commit();
    }
}
