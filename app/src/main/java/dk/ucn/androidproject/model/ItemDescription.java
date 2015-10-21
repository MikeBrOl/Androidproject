package dk.ucn.androidproject.model;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemDescription {
    private long id;
    private String description;
    private String note;
    private int point;
    private String picture;
    private ItemCategory category;
    private boolean isLuxMeasurable;
    private boolean isSlopeMeasurable;

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
        return isLuxMeasurable;
    }

    public void setIsLuxMeasurable(boolean isLuxMeasurable) {
        this.isLuxMeasurable = isLuxMeasurable;
    }

    public boolean isSlopeMeasurable() {
        return isSlopeMeasurable;
    }

    public void setIsSlopeMeasurable(boolean isSlopeMeasurable) {
        this.isSlopeMeasurable = isSlopeMeasurable;
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
