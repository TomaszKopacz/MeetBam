package tomaszkopacz.meetbam.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by tomas on 05.04.2018.
 */

public class LoginService {

    public static void login(Context context, String mail){
        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("user", mail);
        editor.commit();
    }

    public static void logout(Context context){
        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("user");
        editor.commit();
    }
}
