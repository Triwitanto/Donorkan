package donorkan.trw.id.donorkan.view.detailstokdarah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import donorkan.trw.id.donorkan.R;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.tv_jumlah_darah)
    TextView textViewJumlahDarah;
    @BindView(R.id.tv_unit)
    TextView textViewUnit;
    @BindView(R.id.tv_provinsi)
    TextView textViewProvinsi;
    @BindView(R.id.iv_back_darah)
    ImageView ivBack;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private String dataUnit;
    private String dataProvinsi;
    private String dataJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        dataUnit = getIntent().getExtras().getString("unit");
        dataProvinsi = getIntent().getExtras().getString("provinsi");
        dataJumlah = getIntent().getExtras().getString("jumlah");

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewJumlahDarah.setText(dataJumlah);
        textViewProvinsi.setText(dataProvinsi);
        textViewUnit.setText(dataUnit);
    }
}
