package donorkan.trw.id.donorkan.view.liststokdarah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import donorkan.trw.id.donorkan.R;
import donorkan.trw.id.donorkan.model.StokDarah;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  MainView {

    @BindView(R.id.rv_list_stokdarah)
    RecyclerView recyclerViewListSurat;

    private RecyclerViewStokDarah adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        ButterKnife.bind(this);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Beranda");
//        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
//        setSupportActionBar(toolbar);
        presenter.getListSurat("AKfycbxENZUqbOHUz7c7CevxlMJMkjxRMtP5rRim-SjFwcLSO9UDiBk", "b_pos", "AHF","Jawa Barat");
    }
    @Override
    public void showError(String error) {
        Log.d("error", error);
    }

    @Override
    public void showListStokDarah(List<StokDarah> stokDarahs) {
        recyclerViewListSurat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new RecyclerViewStokDarah(this, stokDarahs);
        recyclerViewListSurat.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
