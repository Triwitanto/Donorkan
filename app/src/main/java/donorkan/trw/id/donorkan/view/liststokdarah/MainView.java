package donorkan.trw.id.donorkan.view.liststokdarah;

import donorkan.trw.id.donorkan.model.StokDarah;

import java.util.List;

public interface MainView {

    void showError(String error);

    void showListStokDarah(List<StokDarah> stokDarahs);

}
