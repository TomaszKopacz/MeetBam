package tomaszkopacz.meetbam.presenters;

import android.content.Intent;
import android.os.AsyncTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.activities.LoginActivity;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.User;
import tomaszkopacz.meetbam.service.LoginService;
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 04.04.2018.
 */

public class LoginActivityPresenter {

    private LoginActivity activity;
    private WebService mWebService;
    private LoginService mLoginService;

    public static final int LOGIN_FAILED = -1;
    public static final int LOGIN_SUCCEED = 1;

    public static final int MAIL_EMPTY = 10;
    public static final int PASSWORD_EMPTY = 11;
    public static final int MAIL_INVALID = 12;
    public static final int PASSWORD_TOO_SHORT = 13;

    public static final int NO_SUCH_MAIL = 14;
    public static final int PASSWORD_INVALID = 15;

    private int loginStatus = LOGIN_FAILED;


    /**
     * Constructor.
     * @param activity
     */
    public LoginActivityPresenter(LoginActivity activity, WebService service){
        this.activity = activity;
        this.mWebService = service;
        this.mLoginService = new LoginService(activity.getApplicationContext());
    }

    /**
     * Confirm if any user is logged in. If so, switch to MainActivity.
     */
    public void confirmUserIsSignedIn(){

        // if any user is logged in go to MainActivity
        if (mLoginService.isUserLoggedIn())
            goToMainActivity();
    }

    /**
     * Confirm login mail and password.
     * Login, as an email string, should contain '@' sign.
     * Password should have more than 5 signs.
     * Both login and password cannot be empty.
     * @param mail
     * @param password
     * @return
     */
    public int isLoginInputCorrect(String mail, String password){

        loginStatus = LOGIN_FAILED;

        if (mail.isEmpty())
            loginStatus = MAIL_EMPTY;

        else if (password.isEmpty())
            loginStatus = PASSWORD_EMPTY;

        else if (!mail.contains("@"))
            loginStatus = MAIL_INVALID;

        else if (password.length() < 6)
            loginStatus = PASSWORD_TOO_SHORT;

        else
            attemptLogin(mail, password);

        return loginStatus;
    }

    /**
     * Tries to login the user.
     * @param mail
     * @param password
     */
    private void attemptLogin(String mail, String password){

        UserLoginTask userTask = new UserLoginTask(mail, password);
        userTask.execute();
    }

    /**
     * Asynchronous login task used to authenticate the user.
     */
    private class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

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
            Call<List<User>> call = mWebService.getUser(mEmail);
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                    if (!response.body().isEmpty()) {

                        // user found
                        user = response.body().get(0);

                        // confirm password
                        if (user.getPassword().equals(mPassword)) {
                            login(user);
                            loginStatus = LOGIN_SUCCEED;

                        }  else
                            loginStatus = PASSWORD_INVALID;

                    } else
                        // no user found
                        loginStatus = NO_SUCH_MAIL;
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    loginStatus = LOGIN_FAILED;
                }
            });

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
        }

        @Override
        protected void onCancelled() {
        }
    }

    /**
     * Login.
     */
    private void login(User user){

        String mail = user.getMail();
        String name = user.getName();
        String surname = user.getSurname();
        String password = user.getPassword();

        // login the user
        mLoginService.login(mail, name, surname, password);

        // switch view to MainActivity
        goToMainActivity();
    }

    /**
     * Switches view to MainActivity.
     */
    private void goToMainActivity(){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
