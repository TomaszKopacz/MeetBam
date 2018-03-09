package tomaszkopacz.meetbam.views;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import tomaszkopacz.meetbam.BuildConfig;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.Post;

import static junit.framework.Assert.assertTrue;

/**
 * Created by tomas on 07.03.2018.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp(){
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    /**
     * When setUpLists is called with null argument for list,
     * recycler view should has zero items.
     */
    public void testSetUpListWhenArgumentIsNull(){

        //null list argument
        List<Post> posts = null;

        //call method
        activity.setUpList(posts);

        //check item count - should be three
        assertTrue(activity.getPostsRecView().getAdapter().getItemCount() == 0);
    }

    @Test
    /**
     * When setUpLists is called with list of posts that has zero elements,
     * recycler view should has zero items.
     */
    public void testSetUpListWhenListHasZeroElements(){

        //posts to be displayed - 0 elements
        List<Post> posts = new ArrayList<>();

        //call method
        activity.setUpList(posts);

        //check item count - should be three
        assertTrue(activity.getPostsRecView().getAdapter().getItemCount() == 0);

    }

    @Test
    /**
     * When setUpLists is called with list of posts that is not empty,
     * items should be displayed in recycler view.
     */
    public void testSetUpListWhenListHasElements(){

        //posts to be displayed - 3 elements
        List<Post> posts = new ArrayList<>();
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());

        //call method
        activity.setUpList(posts);

        //check item count - should be three
        assertTrue(activity.getPostsRecView().getAdapter().getItemCount() == 3);
    }
}
