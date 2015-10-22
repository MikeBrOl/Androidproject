package dk.ucn.androidproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dk.ucn.androidproject.model.ItemDescription;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemDescriptionDao {
    private Context context;
    private DBAccess dbAccess;
    private SQLiteDatabase database;
    private String[] allColumns;

    public ItemDescriptionDao(Context context) {
        this.context = context;
        dbAccess = DBAccess.getInstance(context);
        database = dbAccess.getWritableDatabase();
        allColumns = new String[] {ItemDescriptionTableHelper.COLUMN_ID, ItemDescriptionTableHelper.COLUMN_DESCRIPTION, ItemDescriptionTableHelper.COLUMN_CATEGORY};
    }

    public List<ItemDescription> getAllItemDescriptions(){
        List<ItemDescription> itemList = new ArrayList<>();
        String[] result = new String[]{ItemDescriptionTableHelper.COLUMN_ID, ItemDescriptionTableHelper.COLUMN_DESCRIPTION, ItemDescriptionTableHelper.COLUMN_CATEGORY};
        Cursor cursor = database.query(ItemDescriptionTableHelper.TABLE_NAME, result, null, null, null, null, null, null);

        if (cursor.moveToFirst()){
            do {
                itemList.add(cursorToItemDescription(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return itemList;
    }

    private ItemDescription cursorToItemDescription(Cursor cursor) {
        ItemDescription itemDescription = new ItemDescription();
        itemDescription.setId(cursor.getLong(0));
        itemDescription.setDescription(cursor.getString(1));
        itemDescription.setCategory(new ItemCategoryDao(this.context).findCategoryById(cursor.getLong(2)));
        return itemDescription;
    }

    public ItemDescription createItemDescription(String description){
        ItemDescription itemDescription = new ItemDescription(description);
        ContentValues values = new ContentValues();
        values.put(ItemDescriptionTableHelper.COLUMN_DESCRIPTION, description);
        database.insert(ItemDescriptionTableHelper.TABLE_NAME, null, values);
        return itemDescription;
    }


    public List<ItemDescription> getAllByCategory(String category) {
        List<ItemDescription> itemList = new ArrayList<>();
        Cursor cursor = database.query(ItemDescriptionTableHelper.TABLE_NAME, allColumns, ItemDescriptionTableHelper.COLUMN_CATEGORY + " = ?", new String[] {category}, null, null, null, null);

        if (cursor.moveToFirst()){
            do {
                itemList.add(cursorToItemDescription(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return itemList;
    }
}

