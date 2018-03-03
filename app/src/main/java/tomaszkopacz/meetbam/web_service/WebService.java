package tomaszkopacz.meetbam.web_service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import tomaszkopacz.meetbam.model.Post;

/**
 * Created by tomas on 03.03.2018.
 * Communication to database.
 */

public interface WebService {

    @GET("/users.php")
    Call<List<Post>> getData();
}
