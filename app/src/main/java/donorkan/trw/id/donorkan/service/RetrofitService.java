package donorkan.trw.id.donorkan.service;


import donorkan.trw.id.donorkan.common.ApiUrl;
import donorkan.trw.id.donorkan.model.BaseStokDarah;
import retrofit2.Call;

import java.util.List;

/**
 * Created by Kristiawan on 21/04/18.
 * this class for example
 */
public class RetrofitService extends BaseService<RetrofitApi> {

    private static RetrofitService instance;

    public static RetrofitService getInstance() {
        if (instance == null) {
            instance = new RetrofitService();
        }

        return instance;
    }

    public RetrofitService() {
        setApi(RetrofitApi.class);
    }

    public Call<BaseStokDarah> getListStokDarah(String service, String gol, String produk, String provinsi) {
        return getApi().getListStokDarah(ApiUrl.BASE_API + "macros/exec", service, gol, produk, provinsi);
    }

}
