package id.ac.ui.cs.myui;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hafiyyansayyidfadhlillah on 7/25/17.
 */

public interface LoginService {

    @GET("token")
    Call<AccessToken> getAccessToken(@Query("code") String code);
}
