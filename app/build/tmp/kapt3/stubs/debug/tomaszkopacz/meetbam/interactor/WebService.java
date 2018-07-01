package tomaszkopacz.meetbam.interactor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\'J\u001e\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\'J\u001e\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\'J\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000bH\'J\u001e\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000bH\'J\u001e\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\'J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u000bH\'J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\u001aH\'R \u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00038\'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001c"}, d2 = {"Ltomaszkopacz/meetbam/interactor/WebService;", "", "globalResults", "Lretrofit2/Call;", "", "Ltomaszkopacz/meetbam/entity/UserResult;", "getGlobalResults", "()Lretrofit2/Call;", "getFriends", "Ltomaszkopacz/meetbam/entity/User;", "user", "", "getFriendsPosts", "Ltomaszkopacz/meetbam/entity/Post;", "getLocalResults", "getUser", "mail", "getUserLoggedOnDevice", "device", "getUserPosts", "updateLoggedState", "Lokhttp3/ResponseBody;", "uploadPost", "image", "Lokhttp3/MultipartBody$Part;", "user1", "Lokhttp3/RequestBody;", "user2", "app_debug"})
public abstract interface WebService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/get_results.php")
    public abstract retrofit2.Call<java.util.List<tomaszkopacz.meetbam.entity.UserResult>> getGlobalResults();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/users.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<java.util.List<tomaszkopacz.meetbam.entity.User>> getUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "mail")
    java.lang.String mail);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/update_logged.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> updateLoggedState(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "device")
    java.lang.String device, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user")
    java.lang.String mail);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/logged.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<java.util.List<tomaszkopacz.meetbam.entity.User>> getUserLoggedOnDevice(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "device")
    java.lang.String device);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/get_user_posts.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<java.util.List<tomaszkopacz.meetbam.entity.Post>> getUserPosts(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_mail")
    java.lang.String user);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/get_people_posts.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<java.util.List<tomaszkopacz.meetbam.entity.Post>> getFriendsPosts(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_mail")
    java.lang.String user);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "upload_post.php")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<okhttp3.ResponseBody> uploadPost(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part image, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "user1_mail")
    okhttp3.RequestBody user1, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "user2_mail")
    okhttp3.RequestBody user2);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/get_friends.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<java.util.List<tomaszkopacz.meetbam.entity.User>> getFriends(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "mail")
    java.lang.String user);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/get_results.php")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<java.util.List<tomaszkopacz.meetbam.entity.UserResult>> getLocalResults(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "mail")
    java.lang.String user);
}