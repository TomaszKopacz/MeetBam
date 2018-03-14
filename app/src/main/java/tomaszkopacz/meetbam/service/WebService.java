package tomaszkopacz.meetbam.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.model.User;

/**
 * Created by tomas on 03.03.2018.
 * Communication to database.
 */

public interface WebService {

    @GET("/users.php")
    Call<List<User>> getUsers();

    @GET("/posts.php")
    Call<List<Post>> getPosts();
}
