package tomaszkopacz.meetbam.presenters;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.activities.LoginActivity;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.User;
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 04.04.2018.
 */

public class LoginActivityPresenter {

    private LoginActivity activity;
    private WebService service;

    public static final int LOGIN_FAILED = -1;
    public static final int LOGIN_SUCCEED = 1;

    public static final int DATA_VALID = 10;

    public static final int MAIL_EMPTY = 11;
    public static final int PASSWORD_EMPTY = 12;
    public static final int MAIL_INVALID = 13;
    public static final int PASSWORD_TOO_SHORT = 14;

    public static final int NO_SUCH_MAIL = 15;
    public static final int PASSWORD_INVALID = 16;

    private static final String NO_USER = "";

    /**
     * Constructor.
     * @param activity
     */
    public LoginActivityPresenter(LoginActivity activity, WebService service){
        this.activity = activity;
        this.service = service;

        // if any user is logged in go to MainActivity
        if (isUserLoggedIn()){
            goToMainActivity();
        }
    }

    /**
     * Checks, whether any user is logged in.
     * @return
     */
    private boolean isUserLoggedIn(){

        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(activity.getApplicationContext());
        String user = sharedPref.getString("user", NO_USER);

        return (!user.equals(NO_USER)) ? true : false;
    }

    /**
     * Confirm attemptLogin mail and password.
     * Login, as an email string, should contain '@' sign.
     * Password should have more than 5 signs.
     * Both attemptLogin and password cannot be empty.
     * @param mail
     * @param password
     * @return
     */
    public int areDataValid(String mail, String password){
        if (mail.isEmpty())
            return MAIL_EMPTY;
        else if (password.isEmpty())
            return PASSWORD_EMPTY;
        else if (!mail.contains("@"))
            return MAIL_INVALID;
        else if (password.length() < 6)
            return PASSWORD_TOO_SHORT;
        else
            return DATA_VALID;
    }

    /**
     * Tries to login the user.
     * @param mail
     * @param password
     */
    public void attemptLogin(String mail, String password){

        UserLoginTask userTask = new UserLoginTask(mail, password);
        userTask.execute();

    }

    /**
     * Asynchronous login task used to authenticate the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        private User user;

        @Override
        protected Boolean doInBackground(Void... params) {

            // get user
            Call<List<User>> call = service.getUser(mEmail);
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (!response.body().isEmpty())

                        // user found
                        user = response.body().get(0);

                    else

                        // no user found
                        activity.onLoginAttemptResult(NO_SUCH_MAIL);
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    activity.onLoginAttemptResult(LOGIN_FAILED);
                }
            });

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

            if (success && user != null) {
                if (user.getSurname().equals(mPassword)) {

                    // password correct
                    onAttemptLoginResult(LOGIN_SUCCEED, user);

                } else {

                    // password invalid
                    onAttemptLoginResult(PASSWORD_INVALID, null);
                }

            } else {
                activity.onLoginAttemptResult(LOGIN_FAILED);
            }
        }

        @Override
        protected void onCancelled() {
        }
    }

    /**
     * Reacts to attemptLogin attempt.
     * @param result
     */
    private void onAttemptLoginResult(int result, User user){

        if (result == LOGIN_SUCCEED){

            // login successful: login user and go to main activity
            login(user.getMail());
            goToMainActivity();

        } else {

            // attemptLogin failed: pass error message to activity
            activity.onLoginAttemptResult(result);
        }

    }

    /**
     * Saves logged users email to shared preferences.
     * @param mail
     */
    private void login(String mail){

        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(activity.getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("user", mail);
        editor.commit();

    }

    /**
     * Switches activity to MainActivity.
     */
    private void goToMainActivity(){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

}
