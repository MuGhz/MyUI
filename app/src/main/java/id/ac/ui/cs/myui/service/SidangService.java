package id.ac.ui.cs.myui.service;

import java.util.List;

import id.ac.ui.cs.myui.Model.SidangModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by maulana.wisnu on 14/07/17.
 */

public interface SidangService {
    @GET("sisidang/jadwal-sidang-hari-ini")
    Call<List<SidangModel>> listSidang();

}
