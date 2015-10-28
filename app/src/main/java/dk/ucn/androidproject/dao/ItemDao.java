package dk.ucn.androidproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dk.ucn.androidproject.model.Item;

/**
 * Created by ki on 28-10-2015.
 */
public class ItemDao {
    private Context context;
    private DBAccess dbAccess;
    private SQLiteDatabase database;
    private String[] allColumns;

    public ItemDao(Context context) {
        this.dbAccess = DBAccess.getInstance(context);
        this.database = dbAccess.getWritableDatabase();
        this.allColumns = new String[]{ItemTableHelper.COLUMN_ID, ItemTableHelper.COLUMN_DESCRIPTION,
                        ItemTableHelper.COLUMN_POINT, ItemTableHelper.COLUMN_NOTE, ItemTableHelper.COLUMN_PICTURE,
                        ItemTableHelper.COLUMN_LUX, ItemTableHelper.COLUMN_SLOPE, ItemTableHelper.COLUMN_EVALUATION};
    }

    public boolean createItem(Item currentItem, long itemDescriptionId, long evaluationId) {
        ContentValues values = new ContentValues();
        values.put(ItemTableHelper.COLUMN_DESCRIPTION, itemDescriptionId);
        values.put(ItemTableHelper.COLUMN_POINT, currentItem.getPoint());
        values.put(ItemTableHelper.COLUMN_NOTE, currentItem.getNote());
        values.put(ItemTableHelper.COLUMN_PICTURE, currentItem.getPicture());
        values.put(ItemTableHelper.COLUMN_LUX, currentItem.getLux());
        values.put(ItemTableHelper.COLUMN_SLOPE, currentItem.getSlope());
        values.put(ItemTableHelper.COLUMN_EVALUATION, evaluationId);

        return database.insert(ItemTableHelper.TABLE_NAME, null, values) > 0;
    }

    public Item getItem(long evaluationId, long descriptionId) {
        Item item = null;
        Cursor cursor = database.query(ItemTableHelper.TABLE_NAME, allColumns, ItemTableHelper.COLUMN_DESCRIPTION + " = ?" + " AND " +
                ItemTableHelper.COLUMN_EVALUATION + " = ?", new String[]{"" + descriptionId, "" + evaluationId}, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                item = cursorToItem(cursor);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return item;
    }

    private Item cursorToItem(Cursor cursor) {
        Item item = new Item();
        item.setId(cursor.getLong(0));
        //description
        item.setPoint(cursor.getInt(2));
        item.setNote(cursor.getString(3));
        item.setPicture(cursor.getString(4));
        item.setLux(cursor.getString(5));
        item.setSlope(cursor.getString(6));
        //evaluation
        return item;
    }
}
