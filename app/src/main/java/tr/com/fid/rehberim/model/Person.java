package tr.com.fid.rehberim.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.Vector;

/**
 * Created by fidel on 24.02.2018.
 */

public class Person extends BaseModel<Person> {

    public final static String TABLE = "kisiler";
    public final static String ID = "id";
    public final static String ISIM = "isim";
    public final static String SOYISIM = "soyisim";
    public final static String GOSTERILECEK_ISIM = "gosterilecek_isim";
    public final static String NUMARA = "numara";
    public final static String MAIL = "mail";
    public final static String FACEBOOK_ADRESI = "facebook_adresi";
    public final static String INSTAGRAM_ADRESI = "instagram_adresi";
    public final static String TWITTER_ADRESI = "twitter_adresi";
    public final static String YOUTUBE_ADRESI = "youtube_adresi";
    public final static String IL_ID = "il_id";
    public final static String ILCE_ID = "ilce_id";
    public final static String GERCEK_ISIM_MI_GOSTERILECEK = "gercek_isim_mi_gosterilecek";
    public final static String ENGELLENDI_MI = "engellendi_mi";
    public final static String SILINDI_MI = "silindi_mi";
    public final static String IMAGE = "image";

    private String adi;
    private String soyadi;
    private String telefonNo;
    private String mail;
    private String image;
    private String goruntulenecekIsim;
    private String faceBookAdresi;
    private String twitterAdresi;
    private String instagramAdresi;
    private String youtubeAdresi;
    private int ilId;
    private int id;
    private int ilceId;
    private int gercekIsimMiGosterilecek;
    private int engellendiMi;
    private int silindiMi;

    public Person(Context context) {
        super(context);
    }

    public Person(Context context, Cursor cursor) {
        super(context);
        setId(cursor.getInt(0));
        setAdi(cursor.getString(1));
        setSoyadi(cursor.getString(2));
        setTelefonNo(cursor.getString(3));
        setGoruntulenecekIsim(cursor.getString(4));
        setMail(cursor.getString(5));
        setFaceBookAdresi(cursor.getString(6));
        setTwitterAdresi(cursor.getString(7));
        setInstagramAdresi(cursor.getString(8));
        setYoutubeAdresi(cursor.getString(9));
        setIlId(cursor.getInt(10));
        setIlceId(cursor.getInt(11));
        setGercekIsimMiGosterilecek(cursor.getInt(12));
        setEngellendiMi(cursor.getInt(13));
        setSilindiMi(cursor.getInt(14));
        setRecored(true);
    }

    public Person(String adi, String soyadi, String telefonNo, String mail) {
        super(null);
        this.adi = adi;
        this.soyadi = soyadi;
        this.telefonNo = telefonNo;
        this.mail = mail;
    }


    public String getFullName() {
        return getAdi() + " " + getSoyadi();
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGoruntulenecekIsim() {
        return goruntulenecekIsim;
    }

    public void setGoruntulenecekIsim(String goruntulenecekIsim) {
        this.goruntulenecekIsim = goruntulenecekIsim;
    }

    public String getFaceBookAdresi() {
        return faceBookAdresi;
    }

    public void setFaceBookAdresi(String faceBookAdresi) {
        this.faceBookAdresi = faceBookAdresi;
    }

    public String getTwitterAdresi() {
        return twitterAdresi;
    }

    public void setTwitterAdresi(String twitterAdresi) {
        this.twitterAdresi = twitterAdresi;
    }

    public String getInstagramAdresi() {
        return instagramAdresi;
    }

    public void setInstagramAdresi(String instagramAdresi) {
        this.instagramAdresi = instagramAdresi;
    }

    public String getYoutubeAdresi() {
        return youtubeAdresi;
    }

    public void setYoutubeAdresi(String youtubeAdresi) {
        this.youtubeAdresi = youtubeAdresi;
    }

    public int getIlId() {
        return ilId;
    }

    public void setIlId(int ilId) {
        this.ilId = ilId;
    }

    public int getIlceId() {
        return ilceId;
    }

    public void setIlceId(int ilceId) {
        this.ilceId = ilceId;
    }

    @Override
    public void insert() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ISIM, getAdi());
        contentValues.put(SOYISIM, getSoyadi());
        contentValues.put(NUMARA, getTelefonNo());
        contentValues.put(GOSTERILECEK_ISIM, getGoruntulenecekIsim());
        contentValues.put(MAIL, getMail());
        contentValues.put(FACEBOOK_ADRESI, getFaceBookAdresi());
        contentValues.put(TWITTER_ADRESI, getTwitterAdresi());
        contentValues.put(INSTAGRAM_ADRESI, getInstagramAdresi());
        contentValues.put(YOUTUBE_ADRESI, getYoutubeAdresi());
        contentValues.put(IL_ID, getIlId());
        contentValues.put(ILCE_ID, getIlceId());
        contentValues.put(GERCEK_ISIM_MI_GOSTERILECEK, getGercekIsimMiGosterilecek());
        contentValues.put(ENGELLENDI_MI, getEngellendiMi());
        contentValues.put(SILINDI_MI, getSilindiMi());
        contentValues.put(IMAGE, getImage());
        readAbleDB.insert(TABLE, null, contentValues);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Vector<Person> list() {
        Log.e("LIST","LIST");
        Vector<Person> personList = new Vector<>();
        String[] columns = {ID, ISIM, SOYISIM, NUMARA, GOSTERILECEK_ISIM, MAIL, FACEBOOK_ADRESI, TWITTER_ADRESI, INSTAGRAM_ADRESI, YOUTUBE_ADRESI, IL_ID, ILCE_ID, GERCEK_ISIM_MI_GOSTERILECEK, ENGELLENDI_MI, SILINDI_MI};
        Cursor cursor = readAbleDB.query(TABLE, columns, null, null, null, null, ISIM + " ASC");
        if (cursor.moveToFirst())
            do {
                personList.add(new Person(context, cursor));
            } while (cursor.moveToNext());
        cursor.close();
        return personList;
    }

    public int getGercekIsimMiGosterilecek() {
        return gercekIsimMiGosterilecek;
    }

    public void setGercekIsimMiGosterilecek(int gercekIsimMiGosterilecek) {
        this.gercekIsimMiGosterilecek = gercekIsimMiGosterilecek;
    }

    public int getEngellendiMi() {
        return engellendiMi;
    }

    public void setEngellendiMi(int engellendiMi) {
        this.engellendiMi = engellendiMi;
    }

    public int getSilindiMi() {
        return silindiMi;
    }

    public void setSilindiMi(int silindiMi) {
        this.silindiMi = silindiMi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
