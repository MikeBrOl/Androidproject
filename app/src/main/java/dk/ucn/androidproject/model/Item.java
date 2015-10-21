package dk.ucn.androidproject.model;

/**
 * Created by ki on 16-10-2015.
 */
public class Item {
    private long id;
    private ItemDescription description;
    private String note;
    private int point;
    private String picture;
    private String lux;
    private String slope;
    private Evaluation evaluation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ItemDescription getDescription() {
        return description;
    }

    public void setDescription(ItemDescription description) {
        this.description = description;
    }

    public String getLux() {
        return lux;
    }

    public void setLux(String lux) {
        this.lux = lux;
    }

    public String getSlope() {
        return slope;
    }

    public void setSlope(String slope) {
        this.slope = slope;
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

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
