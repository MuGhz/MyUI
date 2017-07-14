package id.ac.ui.cs.myui;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import id.ac.ui.cs.myui.Model.Dosen;
import id.ac.ui.cs.myui.Model.SidangModel;
import id.ac.ui.cs.myui.service.SidangService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by maulana.wisnu on 14/07/17.
 */

public class SidangServiceUnitTest {
    Retrofit client;
    SidangService service;
    Call<List<SidangModel>> call;
    Response<List<SidangModel>> posts;

    @Before
    public void prep(){
        client = new Retrofit.Builder()
                .baseUrl("https://api.cs.ui.ac.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = client.create(SidangService.class);
        call = service.listSidang();
        posts = null;
    }

    @Test
    public void konekAPIberhasil() throws IOException {

        posts = call.execute();
        assertEquals(posts.code(),200);


    }

    @Test
    public void internetJalan() {
        try{
            posts = call.execute();
            assertEquals(posts.isSuccessful(),true);
        } catch (ConnectException e){
            assertEquals(posts.code(),200);
        } catch (IOException e) {
            assertEquals(posts.code(),200);
        }

    }


    @Test
    public void isinyaLengkap() throws IOException {
        posts = call.execute();

        for(int i = 0; i < posts.body().size(); i++){
            //field super
            assertNotNull((posts.body()).get(i).getDosens());
            assertNotNull((posts.body()).get(i).getJammulai());
            assertNotNull((posts.body()).get(i).getJamselesai());
            assertNotNull((posts.body()).get(i).getJenissidang());
            assertNotNull((posts.body()).get(i).getJudul());
            assertNotNull((posts.body()).get(i).getMahasiswa());
            assertNotNull((posts.body()).get(i).getRuangan());
            assertNotNull((posts.body()).get(i).getTanggal());
            assertNotNull((posts.body()).get(i).getTerm());

            //field dosen
            for(int j=0; j< posts.body().size(); j++){
                List<Dosen> siDosen = (posts.body()).get(i).getDosens();
                assertNotNull(siDosen.get(j).getNama());
                assertNotNull(siDosen.get(j).getRole());
            }
        }
    }

}
