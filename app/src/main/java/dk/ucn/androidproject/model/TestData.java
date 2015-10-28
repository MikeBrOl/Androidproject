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
        descriptions.add(new ItemDescription("A1. Trapper smallere end 1,5 m.", categories.get(0), false, false));
        descriptions.add(new ItemDescription("A2. Trappetrin højere end 20 cm.", categories.get(0), false, false));
        descriptions.add(new ItemDescription("A3. Ujævne trappetrin.", categories.get(0), false, false));
        descriptions.add(new ItemDescription("A4. Trappe: Utilstrækkeligt lysforhold.", categories.get(0), true, false));

        descriptions.add(new ItemDescription("A5. Indgang smallere end 1,5 m.", categories.get(1), false, false));
        descriptions.add(new ItemDescription("A6. Ustabil belægning ved indgang.", categories.get(1), false, false));
        descriptions.add(new ItemDescription("A7. Utilstrækkeligt lysforhold.", categories.get(1), true, false));
        descriptions.add(new ItemDescription("A8. Stejle hældninger (over 1:20) ved indgang.", categories.get(1), false, true));

        descriptions.add(new ItemDescription("A9. Elevatordør Smallere end 1,5 m.", categories.get(2), false, false));
        descriptions.add(new ItemDescription("A10. Utilstrækkeligt lysforhold i elevator.", categories.get(2), true, false));

        descriptions.add(new ItemDescription("A11. Ujævnheder på rampen.", categories.get(3), false, false));
        descriptions.add(new ItemDescription("A12. Stejle hældninger (over 1:20).", categories.get(3), false, true));
    }
}