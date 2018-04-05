package tomaszkopacz.meetbam.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.LoginActivityPresenter;
import tomaszkopacz.meetbam.service.WebService;

/**
 * A attemptLogin screen that offers attemptLogin via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private LoginActivityPresenter presenter;

    @Inject
    WebService service;

    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;

    @BindView(R.id.password)
    EditText mPasswordView;

    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;

    @BindView(R.id.login_form)
    View mLoginFormView;

    @BindView(R.id.login_progress)
    View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // bind views
        ButterKnife.bind(this);

        //get dependencies
        ((MainApp)getApplication()).getWebServiceComponent().inject(this);

        // set up presenter
        presenter = new LoginActivityPresenter(this, service);
    }

    @OnClick(R.id.email_sign_in_button)
    public void signInBtn(){

        String mail = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        mEmailView.setError(null);
        mPasswordView.setError(null);

        switch (presenter.areDataValid(mail, password)) {

            case LoginActivityPresenter.DATA_VALID:
                presenter.attemptLogin(mail, password);
                break;

            case LoginActivityPresenter.MAIL_EMPTY:
                mEmailView.setError("Mail cannot be empty");
                mEmailView.requestFocus();
                break;

            case LoginActivityPresenter.PASSWORD_EMPTY:
                mPasswordView.setError("Password cannot be empty");
                mPasswordView.requestFocus();
                break;

            case LoginActivityPresenter.MAIL_INVALID:
                mEmailView.setError("Mail is invalid");
                mEmailView.requestFocus();
                break;

            case LoginActivityPresenter.PASSWORD_TOO_SHORT:
                mPasswordView.setError("Password must have min 6 signs");
                mPasswordView.requestFocus();
                break;
        }
    }

    public void onLoginAttemptResult(int result){
        switch (result){

            case LoginActivityPresenter.NO_SUCH_MAIL:
                Toast.makeText(this, "User does not exist!", Toast.LENGTH_SHORT);
                break;

            case LoginActivityPresenter.PASSWORD_INVALID:
                Toast.makeText(this, "Password is incorrect!", Toast.LENGTH_SHORT);
                break;

            default:
                Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT);
                break;
        }
    }
}
