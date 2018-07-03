//package tomaszkopacz.meetbam.presenter;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import tomaszkopacz.meetbam.entity.Post;
//import tomaszkopacz.meetbam.interactor.WebService;
//import tomaszkopacz.meetbam.view.MainActivity;
//import tomaszkopacz.meetbam.view.MainPostsFragment;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by tomas on 04.03.2018.
// */
//
//public class MainActivityPresenterTest {
//
//    MainPostsFragmentPresenter presenter;
//
//    @Mock
//    MainPostsFragment fragment;
//
//    @Mock
//    WebService service;
//
//    @Mock
//    Call call;
//
//    @Captor
//    ArgumentCaptor<Callback<List<Post>>> captor;
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//
//        presenter = new MainPostsFragmentPresenter(fragment);
//    }
//
//    @Test
//    /**
//     * When posts are downloaded from server, they should have been passed to the list.
//     */
//    public void arePostsProperlyDownloaded(){
//
//        //create list of three posts
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post());
//        posts.add(new Post());
//        posts.add(new Post());
//
//        //don't get posts from server -> mock call instead
//        Mockito.when(service.getPosts()).thenReturn(call);
//
//        //call relevant method
//        presenter.downloadPosts();
//
//        //capture callback and set its body
//        Mockito.verify(call).enqueue(captor.capture());
//        captor.getValue().onResponse(call, Response.success(posts));
//
//        //test contains three posts, so does the list?
//        assertTrue(presenter.getPosts().size() == 3);
//    }
//}