package tomaszkopacz.meetbam.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/**
 * Created by tomas on 05.04.2018.
 */

public class LoginService {

    private static final String USER = "user";
    private static final String NO_USER = "";

    /**
     * Checks, whether any user is logged in.
     * @return
     */
    public static boolean isUserLoggedIn(Context context){

        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(context);
        String user = sharedPref.getString(USER, NO_USER);

        return (!user.equals(NO_USER)) ? true : false;
    }

    /**
     * Returns logged user.
     * @param context
     * @return
     */
    public static String getLoggedUser(Context context){
        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sharedPref.getString(USER, NO_USER);
    }

    /**
     * Login new user. User is determined by giving his email.
     * @param context
     * @param mail
     */
    public static void login(Context context, String mail){
        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USER, mail);
        editor.commit();
    }

    /**
     * Logout user.
     * @param context
     */
    public static void logout(Context context){
        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove(USER);
        editor.commit();
    }
}
