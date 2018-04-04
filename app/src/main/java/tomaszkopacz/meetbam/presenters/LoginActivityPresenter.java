package tomaszkopacz.meetbam.presenters;

import android.content.Intent;
import android.os.AsyncTask;

import tomaszkopacz.meetbam.activities.LoginActivity;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 04.04.2018.
 */

public class LoginActivityPresenter {

    private LoginActivity activity;
    private WebService service;

    public static final int DATA_VALID = 0;
    public static final int MAIL_EMPTY = 1;
    public static final int PASSWORD_EMPTY = 2;
    public static final int MAIL_INVALID = 3;
    public static final int PASSWORD_TOO_SHORT = 4;

    /**
     * Constructor.
     * @param activity
     */
    public LoginActivityPresenter(LoginActivity activity, WebService service){
        this.activity = activity;
        this.service = service;
    }

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

    public void login(String mail, String password){

        UserLoginTask userTask = new UserLoginTask(mail, password);
        userTask.execute();

    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

            if (success) {
                loginSucceed();
            } else {

            }
        }

        @Override
        protected void onCancelled() {
        }
    }

    private void loginSucceed(){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

}
