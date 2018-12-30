package donorkan.trw.id.donorkan.view.liststokdarah;

import donorkan.trw.id.donorkan.model.BaseStokDarah;
import donorkan.trw.id.donorkan.model.StokDarah;
import donorkan.trw.id.donorkan.service.ApiService;
import donorkan.trw.id.donorkan.service.BaseService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView view;

    MainPresenter(MainView view) {
        this.view = view;
    }

    void getListSurat(String service, String gol, String produk, String provinsi){
        ApiService.newInstance()
                .getUserService()
                .getListStokDarah(service, gol, produk, provinsi)
                .enqueue(new Callback<BaseStokDarah>() {
                    @Override
                    public void onResponse(Call<BaseStokDarah> call, Response<BaseStokDarah> response) {
                        try {
                            if (response.body().getStatus().equals("success")){
                                view.showListStokDarah(response.body().getData());
                            }
                            else{
                            }

                        } catch (Exception e) {
                            view.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseStokDarah> call, Throwable t) {
                        view.showError(t.getMessage());
                    }
                });
    }


}
