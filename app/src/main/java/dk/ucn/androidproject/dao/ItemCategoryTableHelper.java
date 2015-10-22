package dk.ucn.androidproject.dao;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemCategoryTableHelper {
    public static final String TABLE_NAME = "category";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT NOT NULL);"
            ;

    public static void onCreate(SQLiteDatabase database){
        Log.i("__ItemCatTable", CREATE_TABLE);
        database.execSQL(CREATE_TABLE);
    }
}
