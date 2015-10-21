package dk.ucn.androidproject.dao;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemTableHelper {
    public static final String TABLE_NAME = " item";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DESCRIPTION = " description_id";
    public static final String COLUMN_POINT = " point";
    public static final String COLUMN_NOTE = " note";
    public static final String COLUMN_PICTURE = " picture";
    public static final String COLUMN_LUX = " lux";
    public static final String COLUMN_SLOPE = " slope";
    private static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + "(" +
                    COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_DESCRIPTION + "INTEGER NOT NULL," +
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
