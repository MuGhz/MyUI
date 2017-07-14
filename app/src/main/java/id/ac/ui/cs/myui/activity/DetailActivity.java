package id.ac.ui.cs.myui.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.helper.RetrofitBuilderHelper;
import id.ac.ui.cs.myui.model.Sidang;
import id.ac.ui.cs.myui.service.SidangService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by faisalagustp on 7/13/17.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        RetrofitBuilderHelper retrofitBuilderHelper = new RetrofitBuilderHelper("https://api.cs.ui.ac.id");
        Retrofit retrofit = retrofitBuilderHelper.getRetrofit();

        SidangService sidangService = retrofit.create(SidangService.class);

        Call<List<Sidang>> call = sidangService.getSidang();

        call.enqueue(new Callback<List<Sidang>>() {
            @Override
            public void onResponse(Call<List<Sidang>> call, Response<List<Sidang>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it

                System.out.println("dah masuk");
                System.out.println(response.body().toString());
                System.out.println(call.request().url().toString());

            }

            @Override
            public void onFailure(Call<List<Sidang>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });


        //Set title bar
        setTitle("My Academic Tracker");
        //Set back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
