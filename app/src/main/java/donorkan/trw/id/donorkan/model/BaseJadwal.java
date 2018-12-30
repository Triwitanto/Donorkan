
package donorkan.trw.id.donorkan.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class BaseJadwal {

    @SerializedName("data")
    private List<Jadwal> mData;

    public List<Jadwal> getData() {
        return mData;
    }

    public void setData(List<Jadwal> data) {
        mData = data;
    }

}
