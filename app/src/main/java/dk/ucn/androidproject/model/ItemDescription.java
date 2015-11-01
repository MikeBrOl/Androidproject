package dk.ucn.androidproject.model;

import android.util.Log;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemDescription {
    private long id;
    private String description;
    private ItemCategory category;
    private boolean luxMeasurable;
    private boolean slopeMeasurable;
    private boolean isHandled;

    public ItemDescription(String description, ItemCategory category, boolean isLuxMeasurable, boolean isSlopeMeasurable) {
        setDescription(description);
        setCategory(category);
        setLuxMeasurable(isLuxMeasurable);
        setSlopeMeasurable(isSlopeMeasurable);
        setIsHandled(false);
    }

    public ItemDescription() {
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isLuxMeasurable() {
        return luxMeasurable;
    }

    public void setLuxMeasurable(boolean luxMeasurable) {
        this.luxMeasurable = luxMeasurable;
    }

    public boolean isSlopeMeasurable() {
        return slopeMeasurable;
    }

    public void setSlopeMeasurable(boolean slopeMeasurable) {
        this.slopeMeasurable = slopeMeasurable;
    }

    public boolean isHandled() {
        return isHandled;
    }

    public void setIsHandled(boolean isHandled) {

        this.isHandled = isHandled;
        Log.i("__setIsHandled", getDescription() + " " + isHandled);
    }
}
