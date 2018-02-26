package tr.com.fid.rehberim.model;

/**
 * Created by fidel on 25.02.2018.
 */

public class Il {

    public static final String TABLE = "il";
    public static final String ID = "id";
    public static final String ADI = "adi";

    private int id;
    private String adi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }
}
