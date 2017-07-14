package id.ac.ui.cs.myui;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import id.ac.ui.cs.myui.activity.DetailActivity;
import id.ac.ui.cs.myui.helper.RetrofitBuilderHelper;
import id.ac.ui.cs.myui.model.Sidang;
import id.ac.ui.cs.myui.service.SidangService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Response responseIni;
    List<Sidang> sidangs;
    String url;
    Call call;


    @Before
    public void retrieve_data(){
        RetrofitBuilderHelper retrofitBuilderHelper = new RetrofitBuilderHelper("https://api.cs.ui.ac.id");
        Retrofit retrofit = retrofitBuilderHelper.getRetrofit();

        SidangService sidangService = retrofit.create(SidangService.class);

        Call<List<Sidang>> call = sidangService.getSidang();

        this.call = call;

    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void server_connected(){

        call.enqueue(new Callback<List<Sidang>>() {
            @Override
            public void onResponse(Call<List<Sidang>> call, Response<List<Sidang>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it


                responseIni= response;
                sidangs = response.body();
                url = call.request().url().toString();
                assertEquals(url, "https://api.cs.ui.ac.id/sisidang/jadwal-sidang-hari-ini/");

            }

            @Override
            public void onFailure(Call<List<Sidang>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });
//        assertEquals(url, "https://api.cs.ui.ac.id/sisidang/jadwal-sidang-hari-ini/");
    }


    @Test
    public void internet_connected(){

        call.enqueue(new Callback<List<Sidang>>() {
            @Override
            public void onResponse(Call<List<Sidang>> call, Response<List<Sidang>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it


                responseIni= response;
                sidangs = response.body();
                url = call.request().url().toString();
                assertEquals(responseIni.code(), 200);

            }

            @Override
            public void onFailure(Call<List<Sidang>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });

    }


    @Test
    public void data_not_null(){
        call.enqueue(new Callback<List<Sidang>>() {
            @Override
            public void onResponse(Call<List<Sidang>> call, Response<List<Sidang>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it


                responseIni= response;
                sidangs = response.body();
                url = call.request().url().toString();
                assertNotNull(sidangs);

            }

            @Override
            public void onFailure(Call<List<Sidang>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });


    }

    @Test
    public void data_retrieved(){
        call.enqueue(new Callback<List<Sidang>>() {
            @Override
            public void onResponse(Call<List<Sidang>> call, Response<List<Sidang>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it


                responseIni= response;
                sidangs = response.body();
                url = call.request().url().toString();
                for (int i = 0; i < sidangs.size(); i++) {
                    assertNotNull(sidangs.get(i).getDosens());
                    assertNotNull(sidangs.get(i).getJamSelesai());
                    assertNotNull(sidangs.get(i).getJudul());
                    assertNotNull(sidangs.get(i).getMahasiswa());
                    assertNotNull(sidangs.get(i).getJudul());
                    assertNotNull(sidangs.get(i).getJenisSidang());
                    assertNotNull(sidangs.get(i).getRuangan());
                    assertNotNull(sidangs.get(i).getTanggal());
                    assertNotNull(sidangs.get(i).getTerm());
                }

            }

            @Override
            public void onFailure(Call<List<Sidang>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
            }
        });
    }



}