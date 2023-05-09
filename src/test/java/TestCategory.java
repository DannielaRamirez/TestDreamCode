import com.products.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestCategory {
    Category product;
    Category furniture;
    Category electronics;
    Category homeAppliances;
    Category majorAppliances;
    Category minorAppliances;
    Category lawnGarden;

    @Before
    public void setProducts(){
        //Create Principals
         product = new Category("Product");
         furniture = new Category("Furniture");
        furniture.setKeywords(new HashSet<>(Arrays.asList("Furniture")));

        electronics = new Category("Electronics");
        electronics.setKeywords(new HashSet<>(Arrays.asList("Electronics","Pc","ElectronicTool")));


         homeAppliances = new Category("HomeAppliances");
        homeAppliances.setKeywords(new HashSet<>(Arrays.asList("Home", "Appliances")));

        //Create Children


         majorAppliances = new Category("MajorAppliances");
        majorAppliances.setKeywords(new HashSet<>(Arrays.asList("Major", "Appliances")));


         minorAppliances = new Category("MinorAppliances");
        minorAppliances.setKeywords(new HashSet<>(Arrays.asList("Minor", "Appliances")));


         lawnGarden = new Category("LawnGarden");
        lawnGarden.setKeywords(new HashSet<>(Arrays.asList("Lawn", "Garden", "GardenTools")));

        //Add to Pather

        product.addChildren(furniture);
        product.addChildren(electronics);
        product.addChildren(homeAppliances);

        homeAppliances.addChildren(majorAppliances);
        homeAppliances.addChildren(minorAppliances);
        homeAppliances.addChildren(lawnGarden);
    }

    @Test
    public void testGetKeywords(){
        Set<String> expected = new HashSet<>(Arrays.asList("Garden", "Appliances", "Lawn", "GardenTools", "Home"));
        assertEquals(expected, lawnGarden.getKeywords());
    }

    @Test
    public void testGetLevel(){
        assertEquals(1, homeAppliances.getLevel());
    }


}
