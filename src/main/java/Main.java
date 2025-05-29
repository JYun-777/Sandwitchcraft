import data.MenuPriceReader;
import data.ReceiptRecord;
import ui.UserInterface;

import static ui.UserInterface.*;

public class Main {

    public static void main (String[] args){
        System.out.println("Welcome to SandWitchCraft!");

        ReceiptRecord rr = new ReceiptRecord();
        rr.saveReceipt();
        UserInterface ui = new UserInterface();
        ui.processHome();
        MenuPriceReader mpr = new MenuPriceReader();
    }
}
