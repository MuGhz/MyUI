package id.ac.ui.cs.myui;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import id.ac.ui.cs.myui.activity.HomeActivity;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hafiyyansayyidfadhlillah on 7/25/17.
 */

public class ServiceGenerator extends AsyncTask<Object, Object, AccessToken> {

    private Context context;
    private String code;

    public ServiceGenerator(Context context, String code){
        this.context = context;
        this.code = code;
    }

    public static final String API_BASE_URL = "https://akun.cs.ui.ac.id/";
    public static final String BACKEND_BASE_URL = "http://10.0.2.2/";

    @Override
    protected AccessToken doInBackground(Object... objects) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        AccessToken data = null;
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BACKEND_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        LoginService loginService = retrofit.create(LoginService.class);
        Call<AccessToken> call = loginService.getAccessToken(code);
        Response<AccessToken> body = null;
        Log.i("CALL",call.request().url().toString());
        try{
            Log.i("FORM",call.request().body().contentType().toString());
        }
        catch (Exception e){

        }
        try{
            body = call.execute();
            String isSuccess = Integer.toString(body.code());
            Log.i("SUCCESS", isSuccess);
            Log.i("REASON", body.message());
            JSONObject jsonResult = new JSONObject(new Gson().toJson(body.body()));
            //JSONObject access_token = jsonResult.getJSONObject("access_token");
            Log.i("TOKEN", jsonResult.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return data;

    }

    @Override
    protected void onPostExecute(AccessToken accessToken) {
        if(!(accessToken == null)){
            Intent i = new Intent(context, HomeActivity.class);
            context.startActivity(i);
        }
    }

}
