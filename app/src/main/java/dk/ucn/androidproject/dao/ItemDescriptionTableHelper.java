package dk.ucn.androidproject.dao;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemDescriptionTableHelper {
    public static final String TABLE_NAME = "item_description";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_CATEGORY = "category_id";
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                    COLUMN_CATEGORY + " INTEGER NOT NULL, " +
                    "FOREIGN KEY(" + COLUMN_CATEGORY + ") REFERENCES " + ItemCategoryTableHelper.TABLE_NAME +
                    "(" + ItemCategoryTableHelper.COLUMN_ID + "));"
            ;

    public static void onCreate(SQLiteDatabase database){
        Log.i("__ItemDescTable", CREATE_TABLE);
        database.execSQL(CREATE_TABLE);
    }
}
