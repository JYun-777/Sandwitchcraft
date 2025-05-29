package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ReceiptTest {

    @Test
    public void addToReceiptWillSumUpPrices(){
        Receipt testReceipt = new Receipt();
        Orderable testOrder1 = new Ingredient("rye", new String[]{"1.0","2.0","3.0"});
        Orderable testOrder2 = new Ingredient("white", new String[]{"2.0","3.0","4.0"});
        testReceipt.addToReceipt(testOrder1, 1);
        testReceipt.addToReceipt(testOrder2,0);
        assertEquals(4.0, testReceipt.getTotalPrice());
    }

    @Test
    public void displayCanDisplayItemNameAndPrice(){
        Receipt testReceipt = new Receipt();
        Orderable testOrder1 = new Ingredient("rye", new String[]{"1.0","2.0","3.0"});
        testReceipt.addToReceipt(testOrder1, 1);
        String expected = String.format("%-15s|%-15.2f", "rye", 2.0);
        String displayString = String.format("%-15s|%-15.2f", testReceipt.getItemList().get(0).getName(), testReceipt.getPriceList().get(0));
        assertEquals(expected,displayString,expected);
    }

}