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
    private String[] allColumns;

    public ItemCategoryDao(Context context){
        dbAccess = DBAccess.getInstance(context);
        database = dbAccess.getWritableDatabase();
        allColumns = new String[] {ItemCategoryTableHelper.COLUMN_ID, ItemCategoryTableHelper.COLUMN_TITLE};
    }

    public List<ItemCategory> getAllCategories(){
        List<ItemCategory> categories = new ArrayList<>();
        Cursor cursor = database.query(ItemCategoryTableHelper.TABLE_NAME, allColumns, null, null, null, null, null, null);
        Integer colIndex = cursor.getColumnIndex(ItemCategoryTableHelper.COLUMN_TITLE);
        if (cursor.moveToFirst()){
            do {
                categories.add(cursorToItemCategory(cursor));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return categories;
    }

    private ItemCategory cursorToItemCategory(Cursor cursor) {
        ItemCategory category = new ItemCategory();
        category.setId(cursor.getLong(0));
        category.setTitle(cursor.getString(1));
        return category;
    }

    public ItemCategory createCategory(String title){
        ItemCategory category = new ItemCategory(title);
        ContentValues values = new ContentValues();
        values.put(ItemCategoryTableHelper.COLUMN_TITLE, title);
        database.insert(ItemCategoryTableHelper.TABLE_NAME, null, values);
        return category;
    }

    public ItemCategory findCategoryById(Long id) {
        Cursor cursor = database.query(ItemCategoryTableHelper.TABLE_NAME, allColumns, ItemCategoryTableHelper.COLUMN_ID + " = ?", new String[] {id.toString()}, null, null, null );
        cursor.moveToFirst();
        ItemCategory category = cursorToItemCategory(cursor);
        cursor.close();
        return category;
    }

    public long getCategoryId(String title) {
        long categoryId = -1;
        String[] columns = new String[] {ItemCategoryTableHelper.COLUMN_ID, ItemCategoryTableHelper.COLUMN_TITLE};
        Cursor cursor = database.query(ItemCategoryTableHelper.TABLE_NAME, columns,
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

