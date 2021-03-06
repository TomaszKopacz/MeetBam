package tomaszkopacz.meetbam.views;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.view.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by tomas on 07.03.2018.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityAndroidTest {

    @Rule
    public IntentsTestRule<MainActivity> activityActivityTestRule
            = new IntentsTestRule<>(MainActivity.class);

    @Before
    public void setUp(){

        // set RESULT_OK when camera is opened
        intending(hasAction(MediaStore.ACTION_IMAGE_CAPTURE))
                .respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, new Intent()));
    }

    @Test
    /**
     * When floating action button is clicked, camera activity should be opened. Assume that user
     * took a photo properly - then CommitPhotoDialog should be displayed.
     */
    public void testFabBtnClicked(){

        // perform click and result is RESULT_OK
        onView(withId(R.id.fab_main)).perform(click());

        // is dialog displayed (dialog contains ImageView with id 'photo')
        onView(withChild(withId(R.id.photo))).check(matches(isDisplayed()));
    }
}
