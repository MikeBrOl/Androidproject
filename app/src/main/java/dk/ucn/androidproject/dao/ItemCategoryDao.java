package dk.ucn.androidproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dk.ucn.androidproject.model.ItemCategory;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemCategoryDao {
    private DBAccess dbAccess;
    private SQLiteDatabase database;

    public ItemCategoryDao(Context context){
        dbAccess = DBAccess.getInstance(context);
        database = dbAccess.getWritableDatabase();
    }

    public List<ItemCategory> getAllCategories(){
        List<ItemCategory> categories = new ArrayList<>();
        String[] result = new String[] {ItemCategoryTableHelper.COLUMN_ID, ItemCategoryTableHelper.COLUMN_TITLE};
        Cursor cursor = database.query(ItemCategoryTableHelper.TABLE_NAME, result, null, null, null, null, null, null);
        Integer colIndex = cursor.getColumnIndex(ItemCategoryTableHelper.COLUMN_TITLE);
        if (cursor.moveToFirst()){
            do {
                categories.add(new ItemCategory(cursor.getString(colIndex)));
            }while (cursor.moveToNext());
        }
        return categories;
    }

    public ItemCategory createCategory(String title){
        ItemCategory category = new ItemCategory(title);
        ContentValues values = new ContentValues();
        values.put(ItemCategoryTableHelper.COLUMN_TITLE, title);
        database.insert(ItemCategoryTableHelper.TABLE_NAME, null, values);
        return category;
    }
}
