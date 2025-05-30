package ui;

import data.Ingredient;
import data.MenuReader;
import data.Receipt;
import data.ReceiptRecord;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static Scanner read = new Scanner(System.in);

    private int menuOption;
    private int sandwichSize = 0;

    private MenuReader menuReader;

    public UserInterface(MenuReader _mpr){
        menuReader = _mpr;
    }

    public void processHome(){

        System.out.print("Please enter an option:\n 1) New Order\n 0) Exit\n>>");
        menuOption = read.nextInt();
        read.nextLine();

        switch (menuOption){
            case 1 -> processOrder();//ReceiptRecord.saveReceipt();
            case 0 -> exit();
        }

    }

    public void processOrder(){

        Receipt newOrder = new Receipt();

        System.out.println("""
                Make your selection:
                 1) Sandwich
                 2) Drink
                 3) Chips
                """);
        System.out.print(">>");
        menuOption = read.nextInt();
        read.nextLine();

        switch(menuOption){
            case 1 -> addSandwich(newOrder);
            case 2 -> addDrink(newOrder);
            case 3 -> addChips(newOrder);
        }

    }

    private void addSandwich(Receipt _rec){
        //sandwich size
        System.out.println("Select a sandwich size:\n 1) 4\"\n 2) 8\"\n 3) 12\"\n >>");
        menuOption = read.nextInt();

        switch(menuOption){
            case 1 -> sandwichSize = 0;
            case 2 -> sandwichSize = 1;
            case 3 -> sandwichSize = 2;
            default -> {
                System.out.println("Invalid sandwich size");
                addSandwich(_rec);
            }
        }

        //bread type
        System.out.print("""
                \nSelect a bread type:
                 1) white
                 2) wheat
                 3) rye
                >>""");
        menuOption = read.nextInt();
        switch (menuOption){
            case 1 -> {
                _rec.addToReceipt(menuReader.searchMenu("rye"), sandwichSize);
            }
        }


        //toppings
        while(true){
            System.out.println("Select your toppings:");
            menuOption = read.nextInt();

        }

    }

    private void addDrink(Receipt _rec){
        System.out.println("Select a drink size:\n 1) Small\n 2) Medium\n 3) Large\n >>");
        menuOption = read.nextInt();

        int drinkSize = 0;
        switch(menuOption){
            case 1 -> drinkSize = 0;
            case 2 -> drinkSize = 1;
            case 3 -> drinkSize = 2;
            default -> {
                System.out.println("Invalid choice");
                addDrink(_rec);
            }
        }

        _rec.addToReceipt(menuReader.searchMenu("Drinks"), menuOption - 1);

    }

    private void addChips(Receipt _rec){

        System.out.println("Chips added to order.");
    }

    public void processCheckout(){

    }

    public void exit(){
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
