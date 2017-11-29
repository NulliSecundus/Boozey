package wisc.boozey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanM on 11/26/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "friend";
    private static final String TABLE_FRIEND_DETAIL = "studentDetails";

    private static final String KEY_NAME = "name";
    private static final String KEY_PLAYED = "played";
    private static final String KEY_WIN = "w";
    private static final String KEY_LOSS = "l";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_FRIEND_DETAIL_TABLE = "CREATE TABLE" + TABLE_FRIEND_DETAIL + "("
                + KEY_NAME + "TEXT,"
                + KEY_PLAYED + "INTEGER,"
                + KEY_WIN + "INTEGER,"
                + KEY_LOSS + "INTEGER" + ")";
        db.execSQL(CREATE_FRIEND_DETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_FRIEND_DETAIL);

        onCreate(db);
    }

    void addNewFriend(Friend newFriend) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, newFriend.getName());
        values.put(KEY_PLAYED, newFriend.getPlayed());
        values.put(KEY_WIN, newFriend.getW());
        values.put(KEY_LOSS, newFriend.getL());

        db.insert(TABLE_FRIEND_DETAIL, null, values);
        db.close();
    }

    public boolean updateFriendInfo(String name, int played, int w, int l) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();

        args.put(KEY_PLAYED, played);
        args.put(KEY_WIN, w);
        args.put(KEY_LOSS, l);

        return db.update(TABLE_FRIEND_DETAIL, args, KEY_NAME + "=" + name, null) > 0;
    }
}
