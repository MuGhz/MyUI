package id.ac.ui.cs.myui.Task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import id.ac.ui.cs.myui.Model.SidangModel;
import id.ac.ui.cs.myui.service.SidangService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maulana.wisnu on 14/07/17.
 */

public class SidangTask extends AsyncTask<Object,Object,List<SidangModel>> {

    private Context context;

    @Override
    protected List<SidangModel> doInBackground(Object... objects) {
        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://api.cs.ui.ac.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SidangService service = client.create(SidangService.class);


        Call<List<SidangModel>> call = service.listSidang();

        Response<List<SidangModel>> posts = null;

        try {
            posts = call.execute();
            Log.d("githubagni", new Gson().toJson(posts.body()));
            Log.d("githubagni", "jalan");

//
           JSONObject resWeather  = new JSONObject(new Gson().toJson(posts.body()));
//            ArrayList<Weather> item = new ArrayList<>();
//
//            JSONObject arrWeather = resWeather.getJSONObject("current");
//            String loc = (resWeather.getJSONObject("location")).getString("name");
//            String temp = arrWeather.getString("temp_c");
//            String wind = arrWeather.getString("wind_mph");
//            Log.d("githubag", loc+temp+wind+"ayam");
//
//            item.add(new Weather(new WeatherApi(temp,wind),new LocationAPi(loc)));
//            return item;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

       return posts.body();

    }
}
