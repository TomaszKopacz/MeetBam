package tomaszkopacz.meetbam.interactor

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.entity.User
import tomaszkopacz.meetbam.entity.UserResult

interface WebService {

    @get:GET("/get_results.php")
    val globalResults: Call<List<UserResult>>

    @FormUrlEncoded
    @POST("/users.php")
    fun getUser(@Field("mail") mail: String): Call<List<User>>

    @FormUrlEncoded
    @POST("/update_logged.php")
    fun updateLoggedState(@Field("device") device: String,
                          @Field("user") mail: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/logged.php")
    fun getUserLoggedOnDevice(@Field("device") device: String): Call<List<User>>

    @FormUrlEncoded
    @POST("/get_user_posts.php")
    fun getUserPosts(@Field("user_mail") user: String): Call<List<Post>>

    @FormUrlEncoded
    @POST("/get_people_posts.php")
    fun getFriendsPosts(@Field("user_mail") user: String): Call<List<Post>>

    @Multipart
    @POST("upload_post.php")
    fun uploadPost(@Part image: MultipartBody.Part,
                   @Part("user1_mail") user1: RequestBody,
                   @Part("user2_mail") user2: RequestBody): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/get_friends.php")
    fun getFriends(@Field("mail") user: String): Call<List<User>>

    @FormUrlEncoded
    @POST("/get_results.php")
    fun getLocalResults(@Field("mail") user: String): Call<List<UserResult>>

}
