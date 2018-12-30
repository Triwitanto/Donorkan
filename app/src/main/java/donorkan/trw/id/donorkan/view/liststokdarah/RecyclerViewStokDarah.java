package donorkan.trw.id.donorkan.view.liststokdarah;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import donorkan.trw.id.donorkan.R;
import donorkan.trw.id.donorkan.model.StokDarah;
import donorkan.trw.id.donorkan.view.detailstokdarah.DetailActivity;

import java.util.List;


public class RecyclerViewStokDarah extends RecyclerView.Adapter<RecyclerViewStokDarah.ViewHolder> {
    private Context context;
    private List<StokDarah> listStokDarah;

    public RecyclerViewStokDarah(Context context, List<StokDarah> listStokDarah) {
        this.context = context;
        this.listStokDarah = listStokDarah;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewStokDarah.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_stokdarah, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvAlamat.setText(listStokDarah.get(position).getUnit());
        holder.tvDaerah.setText(listStokDarah.get(position).getProvinsi());
        holder.tvJumlah.setText(listStokDarah.get(position).getJumlah());
        holder.constraintLayoutStokDarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("unit",listStokDarah.get(position).getUnit());
                intent.putExtra("provinsi", listStokDarah.get(position).getProvinsi());
                intent.putExtra("jumlah", listStokDarah.get(position).getJumlah());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listStokDarah.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cl_stokdarah)
        ConstraintLayout constraintLayoutStokDarah;
        @BindView(R.id.tv_alamat)
        TextView tvAlamat;
        @BindView(R.id.tv_daerah)
        TextView tvDaerah;
        @BindView(R.id.tv_jumlah)
        TextView tvJumlah;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
