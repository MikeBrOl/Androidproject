package dk.ucn.androidproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dk.ucn.androidproject.model.ItemCategory;
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
        allColumns = new String[] {ItemDescriptionTableHelper.COLUMN_ID, ItemDescriptionTableHelper.COLUMN_DESCRIPTION,
                ItemDescriptionTableHelper.COLUMN_CATEGORY, ItemDescriptionTableHelper.COLUMN_IS_LUX_MEASURABLE, ItemDescriptionTableHelper.COLUMN_IS_SLOPE_MEASURABLE};
    }

    public List<ItemDescription> getAllItemDescriptions(){
        List<ItemDescription> itemList = new ArrayList<>();
        Cursor cursor = database.query(ItemDescriptionTableHelper.TABLE_NAME, allColumns, null, null, null, null, null, null);

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
        itemDescription.setLuxMeasurable(cursor.getInt(3) == 1);
        itemDescription.setSlopeMeasurable(cursor.getInt(4) == 1);
        itemDescription.setIsHandled(false);
        return itemDescription;
    }


    public List<ItemDescription> getAllByCategory(long categoryId) {
        List<ItemDescription> itemList = new ArrayList<>();
        Cursor cursor = database.query(ItemDescriptionTableHelper.TABLE_NAME, allColumns, ItemDescriptionTableHelper.COLUMN_CATEGORY + " = ?", new String[] {"" + categoryId}, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                ItemDescription itemDesc = cursorToItemDescription(cursor);
                itemList.add(itemDesc);
                Log.i("__getAllByCat DAO", itemDesc.getCategory().getTitle());
            } while (cursor.moveToNext());
        }
        cursor.close();
        return itemList;
    }
}

