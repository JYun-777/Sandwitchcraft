import data.MenuReader;
import ui.UserInterface;

public class Main {

    public static void main (String[] args){
        System.out.println("Welcome to SandWitchCraft!");

        MenuReader mpr = new MenuReader();

        UserInterface ui = new UserInterface(mpr);
        ui.processHome();
    }
}
