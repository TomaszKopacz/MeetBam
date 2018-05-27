package tomaszkopacz.meetbam.presenters;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.AsyncTask;

import java.util.List;

import okhttp3.ResponseBody;
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

    public LoginActivityPresenter(LoginActivity activity, WebService service){
        this.activity = activity;
        this.mWebService = service;
        this.mLoginService = new LoginService(activity.getApplicationContext());
    }

    public void confirmUserIsSignedIn(){
        if (mLoginService.isUserLoggedIn())
            goToMainActivity();
    }

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

    private void attemptLogin(String mail, String password){
        UserLoginTask userTask = new UserLoginTask(mail, password);
        userTask.execute();
    }

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

            Call<List<User>> call = mWebService.getUser(mEmail);
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                    if (!response.body().isEmpty()) {
                        user = response.body().get(0);

                        if (user.getPassword().equals(mPassword)) {
                            login(user);
                            loginStatus = LOGIN_SUCCEED;

                        }  else
                            loginStatus = PASSWORD_INVALID;

                    } else
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

    private void login(User user){
        String mail = user.getMail();
        String name = user.getName();
        String surname = user.getSurname();
        String password = user.getPassword();
        mLoginService.login(mail, name, surname, password);

        updateUserLoggedOnDevice(mail);

        goToMainActivity();
    }

    private void updateUserLoggedOnDevice(String mail){
        String device = BluetoothAdapter.getDefaultAdapter().getAddress();
        Call<ResponseBody> call = mWebService.updateLoggedState(device, mail);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void goToMainActivity(){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
