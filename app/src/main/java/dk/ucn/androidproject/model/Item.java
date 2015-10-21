package dk.ucn.androidproject.model;

/**
 * Created by ki on 16-10-2015.
 */
public class Item {
    private long id;
    private String description;
    private String note;
    private int point;
    private String picture;
    private ItemCategory category;
    private String measurement;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
