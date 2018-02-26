package tr.com.fid.rehberim.model;

/**
 * Created by fidel on 25.02.2018.
 */

public class Ilce {

    public final static String TABLE = "ilce";
    public final static String ID = "id";
    public final static String IL_ID = "ilce_id";
    public final static String ADI = "adi";

    private int id;
    private int ilId;
    private String adi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIlId() {
        return ilId;
    }

    public void setIlId(int ilId) {
        this.ilId = ilId;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }
}
