package dk.ucn.androidproject.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dk.ucn.androidproject.model.ItemDescription;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemDescriptionDao {
    private DBAccess dbAccess;
    private SQLiteDatabase database;

    public ItemDescriptionDao(Context context) {
        dbAccess = DBAccess.getInstance(context);
        database = dbAccess.getWritableDatabase();
    }

    public List<ItemDescription> getAllItemDescriptions(){
        List<ItemDescription> itemList = new ArrayList<>();
        return itemList;
    }
}
