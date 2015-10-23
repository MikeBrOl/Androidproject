package dk.ucn.androidproject.model;

/**
 * Created by ki on 21-10-2015.
 */
public class ItemDescription {
    private long id;
    private String description;
    private ItemCategory category;

    public ItemDescription(String description, ItemCategory category) {
        setDescription(description);
        setCategory(category);
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

}
