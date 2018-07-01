package tomaszkopacz.meetbam.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tomaszkopacz.meetbam.view.LoginActivity;
import tomaszkopacz.meetbam.interactor.WebService;

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

        int result = presenter.submitInput(mail, password);
        assertTrue(result == presenter.Companion.getMAIL_EMPTY());
    }

    @Test
    public void testAreDataValidWhenPasswordEmpty(){
        String mail = "metbam@gmail.com";
        String password = "";

        int result = presenter.submitInput(mail, password);
        assertTrue(result == presenter.Companion.getPASSWORD_EMPTY());
    }

    @Test
    public void testAreDataValidWhenMailIncorrect(){
        String mail = "meetbam";
        String password = "123456";

        int result = presenter.submitInput(mail, password);
        assertTrue(result == presenter.Companion.getMAIL_INVALID());
    }

    @Test
    public void testAreDataValidWhenPasswordTooShort(){
        String mail = "meetbam@gmail.com";
        String password = "123";

        int result = presenter.submitInput(mail, password);
        assertTrue(result == presenter.Companion.getPASSWORD_TOO_SHORT());
    }

    @Test
    public void testAreDataValidWhenCorrectData(){

        // problem occurs when testing async task  :(

    }
}
