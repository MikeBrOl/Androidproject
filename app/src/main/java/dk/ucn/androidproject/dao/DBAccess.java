package dk.ucn.androidproject.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ki on 16-10-2015.
 */
public class DBAccess extends SQLiteOpenHelper {
    private static DBAccess instance;
    private static final String DATABASE_NAME = "house-enabler-db";
    private static final int VERSION = 1;

    public static DBAccess getInstance(Context context){
        if (instance == null){
            instance = new DBAccess(context.getApplicationContext());
        }
        return instance;
    }

    private DBAccess(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCreateUserTableStatement());
        db.execSQL(getCreateEvaluationTableStatement());
        db.execSQL(getCreateItemCategoryTableStatement());
        db.execSQL(getCreateItemTableStatement());
    }

    private String getCreateUserTableStatement()
    {
        String query = "create table "
                + "users"
                + "(" + "_id integer primary key autoincrement, "
                + "name text not null, "
                + "username text not null, "
                + "password text not null, "
                + "email text not null);";
        return query;
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
