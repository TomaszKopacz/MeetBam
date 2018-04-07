package tomaszkopacz.meetbam.presenters;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import tomaszkopacz.meetbam.activities.LoginActivity;
import tomaszkopacz.meetbam.model.User;
import tomaszkopacz.meetbam.service.WebService;

import static org.junit.Assert.assertTrue;

/**
 * Created by tomas on 06.04.2018.
 */

public class LoginActivityPresenterTest {

    LoginActivityPresenter presenter;

    @Mock
    LoginActivity activity;

    @Mock
    WebService service;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);

        presenter = new LoginActivityPresenter(activity, service);
    }

    @Test
    public void testAreDataValidWhenMailEmpty(){
        String mail = "";
        String password = "123456";

        int result = presenter.isLoginInputCorrect(mail, password);
        assertTrue(result == presenter.MAIL_EMPTY);
    }

    @Test
    public void testAreDataValidWhenPasswordEmpty(){
        String mail = "metbam@gmail.com";
        String password = "";

        int result = presenter.isLoginInputCorrect(mail, password);
        assertTrue(result == presenter.PASSWORD_EMPTY);
    }

    @Test
    public void testAreDataValidWhenMailIncorrect(){
        String mail = "meetbam";
        String password = "123456";

        int result = presenter.isLoginInputCorrect(mail, password);
        assertTrue(result == presenter.MAIL_INVALID);
    }

    @Test
    public void testAreDataValidWhenPasswordTooShort(){
        String mail = "meetbam@gmail.com";
        String password = "123";

        int result = presenter.isLoginInputCorrect(mail, password);
        assertTrue(result == presenter.PASSWORD_TOO_SHORT);
    }

    @Test
    public void testAreDataValidWhenCorrectData(){

        // problem occurs when testing async task  :(

    }
}
