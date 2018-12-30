
package donorkan.trw.id.donorkan.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BaseStokDarah {

    @SerializedName("data")
    private List<StokDarah> mData;
    @SerializedName("status")
    private String mStatus;

    public List<StokDarah> getData() {
        return mData;
    }

    public void setData(List<StokDarah> data) {
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
