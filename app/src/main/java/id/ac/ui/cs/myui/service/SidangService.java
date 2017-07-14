package id.ac.ui.cs.myui.service;

import java.util.List;

import id.ac.ui.cs.myui.model.Sidang;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ekanaradhipa.d on 14/07/17.
 */

public interface SidangService {
    @GET("/sisidang/jadwal-sidang-hari-ini")
    Call<List<Sidang>> getSidang();

}
