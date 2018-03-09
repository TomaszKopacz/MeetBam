package tomaszkopacz.meetbam.views;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.Post;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by tomas on 07.03.2018.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    /**
     * When floating action button is clicked, snack bar should be displayed.
     */
    public void testFabBtnClicked(){

        //perform click
        onView(withId(R.id.fab_main)).perform(click());
        onView(allOf(withText("My text"))).check(matches(isDisplayed()));
    }
}
