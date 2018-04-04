package tomaszkopacz.meetbam.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.LoginActivityPresenter;
import tomaszkopacz.meetbam.service.WebService;

/**
 * A login screen that offers login via email/password.
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
        ButterKnife.bind(this);

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
                presenter.login(mail, password);
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
}

