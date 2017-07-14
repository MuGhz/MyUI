package id.ac.ui.cs.myui.helper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ekanaradhipa.d on 14/07/17.
 */

public class RetrofitBuilderHelper {

    String API_BASE_URL;
    Retrofit retrofit;

    public RetrofitBuilderHelper(String API_BASE_URL) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        this.API_BASE_URL = API_BASE_URL;
        Retrofit.Builder builder= new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        retrofit = builder.client(httpClient.build()).build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
