package tr.com.fid.rehberim.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tr.com.fid.rehberim.model.Il;
import tr.com.fid.rehberim.model.Ilce;
import tr.com.fid.rehberim.model.Person;

/**
 * Created by fidel on 25.02.2018.
 */

public class MyDB extends SQLiteOpenHelper {

    private final static String DB_NAME = "rehberim.db";
    private final static int DB_VERSION = 1;

    public MyDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + Person.TABLE + "("
                + Person.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Person.ISIM + " TEXT,"
                + Person.SOYISIM + " TEXT,"
                + Person.GOSTERILECEK_ISIM + " TEXT,"
                + Person.NUMARA + " TEXT,"
                + Person.MAIL + " TEXT,"
                + Person.FACEBOOK_ADRESI + " TEXT,"
                + Person.INSTAGRAM_ADRESI + " TEXT,"
                + Person.TWITTER_ADRESI + " TEXT,"
                + Person.YOUTUBE_ADRESI + " TEXT,"
                + Person.IMAGE + " TEXT,"
                + Person.IL_ID + " INTEGER,"
                + Person.ILCE_ID + " INTEGER,"
                + Person.ENGELLENDI_MI + " INTEGER,"
                + Person.SILINDI_MI + " INTEGER,"
                + Person.GERCEK_ISIM_MI_GOSTERILECEK + " INTEGER)");

        sqLiteDatabase.execSQL("CREATE TABLE " + Il.TABLE + "("
                + Il.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Il.ADI + " TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + Ilce.TABLE + "("
                + Ilce.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Ilce.IL_ID + " INTEGER,"
                + Ilce.ADI + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
