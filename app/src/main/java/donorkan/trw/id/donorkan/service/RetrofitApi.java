package donorkan.trw.id.donorkan.service;

import donorkan.trw.id.donorkan.model.BaseStokDarah;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by Kristiawan on 21/04/18.
 * this class for example
 */
public interface RetrofitApi {

    @GET
    Call<BaseStokDarah> getListStokDarah(@Url String url,
                                               @Query("service") String service,
                                               @Query("gol") String gol,
                                               @Query("produk") String produk,
                                               @Query("provinsi") String provinsi);

}
