package tr.com.fid.rehberim.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Vector;

import tr.com.fid.rehberim.db.MyDB;

/**
 * Created by fidel on 25.02.2018.
 */

public abstract class BaseModel<T extends BaseModel> {

    public final static int INT_FALSE = 0;
    public final static int INT_TRUE = 1;
    private boolean isRecored;

    protected Context context;
    protected SQLiteDatabase writeAbleDB;
    protected SQLiteDatabase readAbleDB;
    private MyDB db;

    public BaseModel(Context context) {
        this.context = context;
        db = new MyDB(context);
        writeAbleDB = db.getWritableDatabase();
        readAbleDB = db.getReadableDatabase();
    }

    public boolean isRecored() {
        return isRecored;
    }

    public void setRecored(boolean recored) {
        isRecored = recored;
    }

    public abstract void insert();
    public abstract void update();
    public abstract void delete();
    public abstract Vector<T> list();
}
