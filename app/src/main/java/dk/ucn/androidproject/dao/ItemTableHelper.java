package dk.ucn.androidproject.dao;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemTableHelper {
    public static final String TABLE_NAME = "item";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DESCRIPTION = "description_id";
    public static final String COLUMN_POINT = "point";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_PICTURE = "picture";
    public static final String COLUMN_LUX = "lux";
    public static final String COLUMN_SLOPE = "slope";
    public static final String COLUMN_EVALUATION = "evaluation_id";
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DESCRIPTION + " INTEGER NOT NULL, " +
                    COLUMN_POINT + " INTEGER NOT NULL, " +
                    COLUMN_NOTE + " TEXT, " +
                    COLUMN_PICTURE + " TEXT, " +
                    COLUMN_LUX + " TEXT, " +
                    COLUMN_SLOPE +  " TEXT, " +
                    COLUMN_EVALUATION + " INTEGER NOT NULL, " +
                    "FOREIGN KEY(" + COLUMN_DESCRIPTION + ") REFERENCES " + ItemDescriptionTableHelper.TABLE_NAME +
                    "(" + ItemCategoryTableHelper.COLUMN_ID + ")" +
                    "FOREIGN KEY(" + COLUMN_EVALUATION + ") REFERENCES " + EvaluationTableHelper.TABLE_NAME +
                    "(" + EvaluationTableHelper.COLUMN_ID + "));"
            ;

    public static void onCreate(SQLiteDatabase database){
        Log.i("__ItemTable", CREATE_TABLE);
        database.execSQL(CREATE_TABLE);
    }
}
