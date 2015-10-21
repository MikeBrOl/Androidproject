package dk.ucn.androidproject.dao;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemDescriptionTableHelper {
    public static final String TABLE_NAME = " item_description";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DESCRIPTION = " description";
    public static final String COLUMN_CATEGORY = " category_id";
    public static final String COLUMN_POINT = " point";
    public static final String COLUMN_NOTE = " note";
    public static final String COLUMN_PICTURE = " picture";
    public static final String COLUMN_LUX = " isLuxMeasurable";
    public static final String COLUMN_SLOPE = " isSlopeMeasurable";
    private static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + "(" +
                    COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_DESCRIPTION + "TEXT NOT NULL," +
                    COLUMN_CATEGORY + "INTEGER NOT NULL," +
                    COLUMN_POINT + "INTEGER NOT NULL," +
                    COLUMN_NOTE + "TEXT NOT NULL," +
                    COLUMN_PICTURE + "TEXT NOT NULL," +
                    COLUMN_LUX + "TEXT NOT NULL," +
                    COLUMN_SLOPE + "TEXT NOT NULL);"
                    ;

    public static void onCreate(SQLiteDatabase database){
        database.execSQL(CREATE_TABLE);
    }
}
