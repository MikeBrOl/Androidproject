package dk.ucn.androidproject.dao;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ki on 21-10-2015.
 */
public class EvaluationTableHelper {
    public static final String TABLE_NAME = "evaluation";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER = " user_id";
    public static final String COLUMN_DATE = " date";
    private static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + "(" +
                    COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_USER + "INTEGER NOT NULL, +" +
                    COLUMN_DATE + "TEXT NOT NULL);"
            ;

    public static void onCreate(SQLiteDatabase database){
        database.execSQL(CREATE_TABLE);
    }
}
