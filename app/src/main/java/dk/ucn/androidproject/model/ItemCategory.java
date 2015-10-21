package dk.ucn.androidproject.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ki on 16-10-2015.
 */
public class ItemCategory {
    private String title;
    private List<Item> items;

    public ItemCategory(String title) {
        setTitle(title);
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        List<Item> itemList = items;
        return itemList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
