package dk.ucn.androidproject.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ki on 16-10-2015.
 */
public class DBAccess extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "house-enabler-db";

    public DBAccess(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCreateUserTableStatement());
        db.execSQL(getCreateEvaluationTableStatement());
        db.execSQL(getCreateItemCategoryTableStatement());
        db.execSQL(getCreateItemTableStatement());
    }

    private String getCreateUserTableStatement() {
        return null;
    }

    private String getCreateEvaluationTableStatement() {
        return null;
    }

    private String getCreateItemCategoryTableStatement() {
        return null;
    }

    private String getCreateItemTableStatement() {
        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
