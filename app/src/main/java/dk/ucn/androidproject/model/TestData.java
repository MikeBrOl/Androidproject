package dk.ucn.androidproject.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ki on 23-10-2015.
 */
public class TestData {
    private List<ItemCategory> categories;
    private List<ItemDescription> descriptions;

    public TestData(){
        setCategories();
        setDescriptions();
    }

    public List<ItemCategory> getCategories() {
        return categories;
    }

    public List<ItemDescription> getDescriptions() {
        return descriptions;
    }

    private void setCategories() {
        categories = new ArrayList<>();
        categories.add(new ItemCategory("Trappe"));
        categories.add(new ItemCategory("Indgag"));
        categories.add(new ItemCategory("Elevator"));
        categories.add(new ItemCategory("Ramper"));
    }

    private void setDescriptions() {
        descriptions = new ArrayList<>();
        descriptions.add(new ItemDescription("Smallere end 1,5 m.", categories.get(0)));
        descriptions.add(new ItemDescription("Trappetrin højere end 20 cm.", categories.get(0)));
        descriptions.add(new ItemDescription("Ujævne trappetrin.", categories.get(0)));
        descriptions.add(new ItemDescription("Utilstrækkeligt lysforhold.", categories.get(0)));

        descriptions.add(new ItemDescription("Indgang smallere end 1,5 m.", categories.get(1)));
        descriptions.add(new ItemDescription("Ustabil belægning.", categories.get(1)));
        descriptions.add(new ItemDescription("Utilstrækkeligt lysforhold.", categories.get(1)));
        descriptions.add(new ItemDescription("Stejle hældninger (over 1:20).", categories.get(1)));

        descriptions.add(new ItemDescription("Smallere end 1,5 m.", categories.get(2)));
        descriptions.add(new ItemDescription("Utilstrækkeligt lysforhold.", categories.get(2)));

        descriptions.add(new ItemDescription("Ujævnheder på rampen.", categories.get(3)));
        descriptions.add(new ItemDescription("Stejle hældninger (over 1:20).", categories.get(3)));
    }
}