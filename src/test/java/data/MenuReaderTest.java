package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuReaderTest {

    @Test
    public void searchIngredientAndGetName(){
        MenuReader testMpr = new MenuReader();
        Ingredient testIng = (Ingredient)testMpr.searchMenu("rye");
        assertEquals("rye",testIng.getName());
    }

    @Test
    public void searchIngredientAndGetPrices(){
        MenuReader testMpr = new MenuReader();
        Ingredient testIng = (Ingredient)testMpr.searchMenu("rye");
        assertEquals("5.50", testIng.getPrices()[0]);
    }
}