package dk.ucn.androidproject.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.util.Log;

import dk.ucn.androidproject.model.ItemCategory;
import dk.ucn.androidproject.model.ItemDescription;
import dk.ucn.androidproject.model.TestData;

/**
 * Created by ki on 16-10-2015.
 */
public class DBAccess extends SQLiteOpenHelper {
    private static DBAccess instance;
    private static final String DATABASE_NAME = "house-enabler-db";
    private static final int VERSION = 1;

    private class InsertTestDataTask extends AsyncTask<SQLiteDatabase, Integer, Boolean> {

        private TestData testData = new TestData();

        @Override
        protected Boolean doInBackground(SQLiteDatabase... params) {
            Boolean res = false;
            try {
                insertCategoriesBulk(params[0]);
                insertDescriptionsBulk(params[0]);
                res = true;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return res;
        }

        private void insertCategoriesBulk(SQLiteDatabase db) {
            String sql = "INSERT INTO " + ItemCategoryTableHelper.TABLE_NAME + " VALUES (?, ?);";
            Log.i("__InsertCat", sql);
            SQLiteStatement statement = db.compileStatement(sql);
            db.beginTransaction();
            for (ItemCategory category : testData.getCategories()){
                statement.clearBindings();
                statement.bindString(2, category.getTitle());
                statement.execute();
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }

        private void insertDescriptionsBulk(SQLiteDatabase db) {
            String sql = "INSERT INTO " + ItemDescriptionTableHelper.TABLE_NAME + " VALUES (?, ?, ?);";
            Log.i("__InsertDesc", sql);
            SQLiteStatement statement = db.compileStatement(sql);
            db.beginTransaction();
            for (ItemDescription desc : testData.getDescriptions()){
                statement.clearBindings();
                statement.bindString(2, desc.getDescription());
                statement.bindLong(3, getForeignKeyIndex(db, desc.getCategory().getTitle()));
                statement.execute();
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }

        private long getForeignKeyIndex(SQLiteDatabase db, String title) {
            long categoryId = -1;
            String[] columns = new String[] {ItemCategoryTableHelper.COLUMN_ID, ItemCategoryTableHelper.COLUMN_TITLE};
            Cursor cursor = db.query(ItemCategoryTableHelper.TABLE_NAME, columns,
                    ItemCategoryTableHelper.COLUMN_TITLE + " = ?", new String[] {title}, null, null, null, null);
            Integer colIndex = cursor.getColumnIndex(ItemCategoryTableHelper.COLUMN_ID);
            if (cursor.moveToFirst()){
                do {
                    categoryId = cursor.getLong(colIndex);
                } while (cursor.moveToNext());
            }
            cursor.close();
            return categoryId;
        }
    }

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
        ItemCategoryTableHelper.onCreate(db);
        EvaluationTableHelper.onCreate(db);
        ItemDescriptionTableHelper.onCreate(db);
        ItemTableHelper.onCreate(db);
        insertData(db);
    }

    private String getCreateUserTableStatement()
    {
        String query = "create table "
                + "users"
                + "(_id integer primary key autoincrement, "
                + "name text not null, "
                + "username text not null, "
                + "password text not null, "
                + "email text not null);";
        return query;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("__DBAcess", "onUpgrade");
        //DROP: Item, ItemDescription, ItemCategory, Evaluation, User
        String DROP = "DROP TABLE IF EXISTS ";
        db.execSQL(DROP + ItemTableHelper.TABLE_NAME);
        db.execSQL(DROP + ItemDescriptionTableHelper.TABLE_NAME);
        db.execSQL(DROP + ItemCategoryTableHelper.TABLE_NAME);
        db.execSQL(DROP + EvaluationTableHelper.TABLE_NAME);
        db.execSQL(DROP + "users");

        //CREATE: User, ItemCategory, Evaluation, ItemDescription, Item
        this.onCreate(db);

    }

    private void insertData(SQLiteDatabase db) {
        new InsertTestDataTask().execute(db);
        Log.i("__insertDataCalled", "" + VERSION);
    }
}
