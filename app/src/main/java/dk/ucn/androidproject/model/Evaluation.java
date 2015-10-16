package dk.ucn.androidproject.model;

import java.util.Date;
import java.util.List;

/**
 * Created by ki on 16-10-2015.
 */
public class Evaluation {
    private Date date;
    private List<Item> evaluatedItems;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getEvaluatedItems() {
        return evaluatedItems;
    }

    public void setEvaluatedItems(List<Item> evaluatedItems) {
        this.evaluatedItems = evaluatedItems;
    }
}
