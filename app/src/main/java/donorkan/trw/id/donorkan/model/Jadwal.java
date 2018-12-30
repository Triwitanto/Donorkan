
package donorkan.trw.id.donorkan.model;

import com.google.gson.annotations.SerializedName;


public class Jadwal {

    @SerializedName("hari")
    private String mHari;
    @SerializedName("jam")
    private String mJam;
    @SerializedName("makul")
    private String mMakul;
    @SerializedName("ruang")
    private String mRuang;

    public String getHari() {
        return mHari;
    }

    public void setHari(String hari) {
        mHari = hari;
    }

    public String getJam() {
        return mJam;
    }

    public void setJam(String jam) {
        mJam = jam;
    }

    public String getMakul() {
        return mMakul;
    }

    public void setMakul(String makul) {
        mMakul = makul;
    }

    public String getRuang() {
        return mRuang;
    }

    public void setRuang(String ruang) {
        mRuang = ruang;
    }

}
