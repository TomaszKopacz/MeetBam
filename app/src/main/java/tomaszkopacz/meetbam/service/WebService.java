package tomaszkopacz.meetbam.service;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.model.User;
import tomaszkopacz.meetbam.model.UserResult;

/**
 * Created by tomas on 03.03.2018.
 * Communication to database.
 */

public interface WebService {

    @GET("/users.php")
    Call<List<User>> getUsers();

    @FormUrlEncoded
    @POST("/users.php")
    Call<List<User>> getUser(@Field("mail") String mail);

    @FormUrlEncoded
    @POST("/update_logged.php")
    Call<ResponseBody> updateLoggedState(@Field("device") String device,
                                         @Field("user") String mail);

    @FormUrlEncoded
    @POST("/logged.php")
    Call<List<User>> getUserLoggedOnDevice(@Field("device") String device);

    @FormUrlEncoded
    @POST("/get_user_posts.php")
    Call<List<Post>> getUserPosts(@Field("user_mail") String user);

    @FormUrlEncoded
    @POST("/get_people_posts.php")
    Call<List<Post>> getFriendsPosts(@Field("user_mail") String user);

    @Multipart
    @POST("upload_post.php")
    Call<ResponseBody> uploadPost(@Part MultipartBody.Part image,
                                  @Part("user1_mail") RequestBody user1,
                                  @Part("user2_mail") RequestBody user2);

    @FormUrlEncoded
    @POST("/get_friends.php")
    Call<List<User>> getFriends(@Field("mail") String user);

    @GET("/get_results.php")
    Call<List<UserResult>> getGlobalResults();

    @FormUrlEncoded
    @POST("/get_results.php")
    Call<List<UserResult>> getLocalResults(@Field("mail") String user);

}
