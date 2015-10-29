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
        categories.add(new ItemCategory("Køkken"));
        categories.add(new ItemCategory("Bad"));
        categories.add(new ItemCategory("Vinduer"));
        categories.add(new ItemCategory("Siddepladser"));
        categories.add(new ItemCategory("KategoriX"));
        categories.add(new ItemCategory("KategoriY"));
        categories.add(new ItemCategory("KategoriZ"));
        categories.add(new ItemCategory("KategoriV"));
        categories.add(new ItemCategory("KategoriO"));
        categories.add(new ItemCategory("KategoriP"));
        categories.add(new ItemCategory("KategoriQ"));

    }

    private void setDescriptions() {
        descriptions = new ArrayList<>();
        descriptions.add(new ItemDescription("A1. Trapper smallere end 1,5 m.", categories.get(0), false, false));
        descriptions.add(new ItemDescription("A2. Trappetrin højere end 20 cm.", categories.get(0), false, false));
        descriptions.add(new ItemDescription("A3. Ujævne trappetrin.", categories.get(0), false, false));
        descriptions.add(new ItemDescription("A4. Trappe: Utilstrækkeligt lysforhold.", categories.get(0), true, false));
        descriptions.add(new ItemDescription("A5. Gelænder mangelfuldt", categories.get(0), false, false));

        descriptions.add(new ItemDescription("A6. Indgang smallere end 1,5 m.", categories.get(1), false, false));
        descriptions.add(new ItemDescription("A7. Ustabil belægning ved indgang.", categories.get(1), false, false));
        descriptions.add(new ItemDescription("A8. Utilstrækkeligt lysforhold.", categories.get(1), true, false));
        descriptions.add(new ItemDescription("A9. Stejle hældninger (over 1:20) ved indgang.", categories.get(1), false, true));

        descriptions.add(new ItemDescription("A10. Elevatordør Smallere end 1,5 m.", categories.get(2), false, false));
        descriptions.add(new ItemDescription("A11. Utilstrækkeligt lysforhold i elevator.", categories.get(2), true, false));

        descriptions.add(new ItemDescription("A12. Ujævnheder på rampen.", categories.get(3), false, false));
        descriptions.add(new ItemDescription("A13. Stejle hældninger (over 1:20).", categories.get(3), false, true));
        descriptions.add(new ItemDescription("A14. Ustabil rampe.", categories.get(3), false, false));

        descriptions.add(new ItemDescription("A15. Beskrivelse...", categories.get(4), false, false));
        descriptions.add(new ItemDescription("A16. Beskrivelse...", categories.get(4), false, false));
        descriptions.add(new ItemDescription("A17. Beskrivelse...", categories.get(4), true, false));
        descriptions.add(new ItemDescription("A18. Beskrivelse...", categories.get(4), false, true));
        descriptions.add(new ItemDescription("A19. Beskrivelse...", categories.get(4), true, false));
        descriptions.add(new ItemDescription("A20. Beskrivelse...", categories.get(4), false, false));
        descriptions.add(new ItemDescription("A21. Beskrivelse...", categories.get(4), false, false));

        descriptions.add(new ItemDescription("A22. Beskrivelse...", categories.get(5), false, false));
        descriptions.add(new ItemDescription("A23. Beskrivelse...", categories.get(5), false, false));
        descriptions.add(new ItemDescription("A24. Beskrivelse...", categories.get(5), false, false));
        descriptions.add(new ItemDescription("A25. Beskrivelse...", categories.get(5), true, false));
        descriptions.add(new ItemDescription("A26. Beskrivelse...", categories.get(5), false, true));
        descriptions.add(new ItemDescription("A27. Beskrivelse...", categories.get(5), false, false));

        descriptions.add(new ItemDescription("A28. Beskrivelse...", categories.get(6), false, false));
        descriptions.add(new ItemDescription("A29. Beskrivelse...", categories.get(6), false, false));
        descriptions.add(new ItemDescription("A30. Beskrivelse...", categories.get(6), true, false));
        descriptions.add(new ItemDescription("A31. Beskrivelse...", categories.get(6), false, true));
        descriptions.add(new ItemDescription("A32. Beskrivelse...", categories.get(6), false, false));
        descriptions.add(new ItemDescription("A33. Beskrivelse...", categories.get(6), false, false));

        descriptions.add(new ItemDescription("A34. Beskrivelse...", categories.get(7), false, false));
        descriptions.add(new ItemDescription("A35. Beskrivelse...", categories.get(7), false, false));
        descriptions.add(new ItemDescription("A36. Beskrivelse...", categories.get(7), true, false));
        descriptions.add(new ItemDescription("A37. Beskrivelse...", categories.get(7), false, true));
        descriptions.add(new ItemDescription("A38. Beskrivelse...", categories.get(7), false, false));
        descriptions.add(new ItemDescription("A39. Beskrivelse...", categories.get(7), false, false));
        descriptions.add(new ItemDescription("A40. Beskrivelse...", categories.get(7), false, false));

        descriptions.add(new ItemDescription("A41. Beskrivelse...", categories.get(8), false, false));
        descriptions.add(new ItemDescription("A42. Beskrivelse...", categories.get(8), false, false));
        descriptions.add(new ItemDescription("A43. Beskrivelse...", categories.get(8), true, false));
        descriptions.add(new ItemDescription("A44. Beskrivelse...", categories.get(8), false, true));
        descriptions.add(new ItemDescription("A45. Beskrivelse...", categories.get(8), false, false));

        descriptions.add(new ItemDescription("A46. Beskrivelse...", categories.get(9), false, false));
        descriptions.add(new ItemDescription("A47. Beskrivelse...", categories.get(9), false, false));
        descriptions.add(new ItemDescription("A48. Beskrivelse...", categories.get(9), true, false));
        descriptions.add(new ItemDescription("A49. Beskrivelse...", categories.get(9), false, true));
        descriptions.add(new ItemDescription("A50. Beskrivelse...", categories.get(9), false, false));

        descriptions.add(new ItemDescription("A51. Beskrivelse...", categories.get(10), false, false));
        descriptions.add(new ItemDescription("A52. Beskrivelse...", categories.get(10), false, false));
        descriptions.add(new ItemDescription("A53. Beskrivelse...", categories.get(10), true, false));
        descriptions.add(new ItemDescription("A54. Beskrivelse...", categories.get(10), false, true));
        descriptions.add(new ItemDescription("A55. Beskrivelse...", categories.get(10), false, false));

        descriptions.add(new ItemDescription("A56. Beskrivelse...", categories.get(11), false, false));
        descriptions.add(new ItemDescription("A57. Beskrivelse...", categories.get(11), false, false));
        descriptions.add(new ItemDescription("A58. Beskrivelse...", categories.get(11), true, false));
        descriptions.add(new ItemDescription("A59. Beskrivelse...", categories.get(11), false, true));
        descriptions.add(new ItemDescription("A60. Beskrivelse...", categories.get(11), false, false));

        descriptions.add(new ItemDescription("A61. Beskrivelse...", categories.get(12), false, false));
        descriptions.add(new ItemDescription("A62. Beskrivelse...", categories.get(12), false, false));
        descriptions.add(new ItemDescription("A63. Beskrivelse...", categories.get(12), true, false));
        descriptions.add(new ItemDescription("A64. Beskrivelse...", categories.get(12), false, true));
        descriptions.add(new ItemDescription("A65. Beskrivelse...", categories.get(12), false, false));

        descriptions.add(new ItemDescription("A66. Beskrivelse...", categories.get(13), false, false));
        descriptions.add(new ItemDescription("A67. Beskrivelse...", categories.get(13), false, false));
        descriptions.add(new ItemDescription("A68. Beskrivelse...", categories.get(13), true, false));
        descriptions.add(new ItemDescription("A69. Beskrivelse...", categories.get(13), false, true));
        descriptions.add(new ItemDescription("A70. Beskrivelse...", categories.get(13), false, false));

        descriptions.add(new ItemDescription("A71. Beskrivelse...", categories.get(14), false, false));
        descriptions.add(new ItemDescription("A72. Beskrivelse...", categories.get(14), false, false));
        descriptions.add(new ItemDescription("A73. Beskrivelse...", categories.get(14), true, false));
        descriptions.add(new ItemDescription("A74. Beskrivelse...", categories.get(14), false, true));
        descriptions.add(new ItemDescription("A75. Beskrivelse...", categories.get(14), false, false));
    }
}