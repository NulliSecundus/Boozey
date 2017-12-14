package wisc.boozey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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
    private static final String TABLE_FRIEND_DETAIL = "friendDetails";

    private static final String KEY_NAME = "name";
    private static final String KEY_PLAYED = "played";
    private static final String KEY_WIN = "w";
    private static final String KEY_LOSS = "l";
    private static final String KEY_USER = "isUser";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_FRIEND_DETAIL_TABLE = "CREATE TABLE" + TABLE_FRIEND_DETAIL + "("
                + KEY_NAME + "TEXT,"
                + KEY_PLAYED + "INTEGER,"
                + KEY_WIN + "INTEGER,"
                + KEY_LOSS + "INTEGER,"
                + KEY_USER + "INTEGER," + ")";
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
        values.put(KEY_USER, newFriend.getIsUser());

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

    public Friend getUser(int isUser) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FRIEND_DETAIL, new String[] { KEY_NAME, KEY_PLAYED, KEY_WIN,
                KEY_LOSS, KEY_USER }, KEY_USER + "=?", new String[] { String.valueOf(isUser) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Friend friend = new Friend(cursor.getString(0), Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)));

        return friend;
    }

    public Friend getFriend(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FRIEND_DETAIL, new String[] { KEY_NAME, KEY_PLAYED,KEY_WIN,
            KEY_LOSS }, KEY_NAME + "=?", new String[] { name }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Friend friend = new Friend(cursor.getString(0), Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)));

        return friend;
    }
}
