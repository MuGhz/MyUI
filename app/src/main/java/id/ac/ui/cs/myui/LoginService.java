package id.ac.ui.cs.myui;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by hafiyyansayyidfadhlillah on 7/25/17.
 */

public interface LoginService {
    @FormUrlEncoded
    @POST("/oauth/token/")
    Call<AccessToken> getAccessToken(
            @Field("code") String code,
            @Field("grant_type") String grantType, @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret, @Field("redirect_uri") String redUrl);
}
