package tomaszkopacz.meetbam.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/**
 * Created by tomas on 05.04.2018.
 */

public class LoginService {

    private static SharedPreferences sharedPreferences;

    private static final String MAIL = "mail";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PASSWORD = "password";
    private static final String NO_USER = "";

    public LoginService(Context context){

        this.sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
    }

    public boolean isUserLoggedIn(){

        String user = sharedPreferences.getString(MAIL, NO_USER);

        return (!user.equals(NO_USER)) ? true : false;
    }

    public static String getUserMail(){
        return sharedPreferences.getString(MAIL, NO_USER);
    }

    public static String getUserName(){
        return sharedPreferences.getString(NAME, NO_USER);
    }

    public static String getUserSurname(){
        return sharedPreferences.getString(SURNAME, NO_USER);
    }

    public static String getUserPassword(){
        return sharedPreferences.getString(PASSWORD, NO_USER);
    }


    public void login(String mail, String name, String surname, String pwd){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MAIL, mail);
        editor.putString(NAME, name);
        editor.putString(SURNAME, surname);
        editor.putString(PASSWORD, pwd);
        editor.commit();
    }

    public void logout(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MAIL);
        editor.remove(NAME);
        editor.remove(SURNAME);
        editor.remove(PASSWORD);
        editor.commit();
    }
}
