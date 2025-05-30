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
            case 1 -> {
                Receipt newOrder = new Receipt();
                processOrder(newOrder);
            }
            case 0 -> exit();
        }

    }

    public void processOrder(Receipt _rec){


        System.out.println("""
                Make your selection:
                 1) Sandwich
                 2) Drink
                 3) Chips
                 4) Continue to Checkout
                """);
        System.out.print(">>");
        menuOption = read.nextInt();
        read.nextLine();

        switch(menuOption){
            case 1 -> addSandwich(_rec);
            case 2 -> addDrink(_rec);
            case 3 -> addChips(_rec);
            case 4 -> processCheckout(_rec);
            default -> {
                System.out.println("Invalid menu option.");
                processOrder(_rec);
            }
        }

    }

    private void addSandwich(Receipt _rec){
        //sandwich size
        System.out.println("Select a sandwich size:\n 1) 4\"\n 2) 8\"\n 3) 12\"\n>>");
        menuOption = read.nextInt();
        read.nextLine();

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
        breadPrompt: while(true) {
            System.out.print("""
                    \nSelect a bread type:
                     1) white
                     2) wheat
                     3) rye
                    >>""");
            menuOption = read.nextInt();
            read.nextLine();
            switch (menuOption) {
                case 1 -> {
                    _rec.addToReceipt(menuReader.searchMenu("white"), sandwichSize);
                    break breadPrompt;
                }
                case 2 -> {
                    _rec.addToReceipt(menuReader.searchMenu("wheat"), sandwichSize);
                    break breadPrompt;
                }
                case 3 -> {
                    _rec.addToReceipt(menuReader.searchMenu("rye"), sandwichSize);
                    break breadPrompt;
                }
                default -> {
                    System.out.println("Invalid option.");
                }
            }
        }


        //toppings
        String toppingOption;
        while(true){
            System.out.println("Enter the name of a topping to add it, or enter X to continue to next step:");
            System.out.println("""
                                 _____MEATS_____|_____CHEESES_____|_____TOPPINGS_____|_____SAUCES_____
                                      steak     |     american    |     lettuce      |      mayo          
                                       ham      |    provolone    |     peppers      |     mustard               
                                      salami    |     cheddar     |     onions       |     ketchup              
                                    roast beef  |      swiss      |     tomatoes     |     ranch 
                                     chicken    |                 |     jalapenos    | thousand island        
                                      bacon     |                 |     cucumbers    |   vinaigrette        
                                                |                 |      pickles     |                  
                                                |                 |     guacamole    |                  
                                                |                 |     mushrooms    |                   \n
                                 """);
            System.out.print(">>");

            toppingOption = read.nextLine();

            if (toppingOption.equalsIgnoreCase("x")){
                break;
            }else if (menuReader.searchMenu(toppingOption) != null){
                _rec.addToReceipt(menuReader.searchMenu(toppingOption), sandwichSize);
                System.out.printf("%s added\n", menuReader.searchMenu(toppingOption).getName());
            }

        }

        //toasted
        toastPrompt: while(true) {
            System.out.println("Would you like your sandwich toasted? Enter 1 if YES, 2 if NO.");
            menuOption = read.nextInt();
            read.nextLine();
            switch (menuOption){
                case 1: _rec.addToReceipt(menuReader.searchMenu("toasted"), sandwichSize);
                case 2: {
                    break toastPrompt;
                }
                default: {
                    System.out.println("Invalid option.");
                }
            }
        }

        System.out.println("Sandwich added to order.");
        processOrder(_rec);
    }

    private void addDrink(Receipt _rec){
        System.out.println("Select a drink size:\n 1) Small\n 2) Medium\n 3) Large\n>>");
        menuOption = read.nextInt();
        read.nextLine();

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

        System.out.println("Select a drink flavor:\n 1) Coke\n 2) Dr.Pepper\n 3) Fanta\n 4) Sprite\n");
        System.out.print(">>");
        menuOption = read.nextInt();
        read.nextLine();

        switch (menuOption) {
            case 1 -> _rec.addToReceipt(menuReader.searchMenu("Coke"), drinkSize);
            case 2 -> _rec.addToReceipt(menuReader.searchMenu("Dr.Pepper"), drinkSize);
            case 3 -> _rec.addToReceipt(menuReader.searchMenu("Fanta"), drinkSize);
            case 4 -> _rec.addToReceipt(menuReader.searchMenu("Sprite"), drinkSize);
            default -> {
                System.out.println("Invalid option.");
                addDrink(_rec);
            }

        }

        System.out.println("Drink added to order.");
        processOrder(_rec);

    }

    private void addChips(Receipt _rec){
        System.out.println("Select a chip type:\n 1) Lays\n 2) Doritos\n 3) Fritos\n");
        System.out.print(">>");
        menuOption = read.nextInt();
        read.nextLine();

        switch (menuOption) {
            case 1 -> _rec.addToReceipt(menuReader.searchMenu("Lays"), sandwichSize);
            case 2 -> _rec.addToReceipt(menuReader.searchMenu("Doritos"), sandwichSize);
            case 3 -> _rec.addToReceipt(menuReader.searchMenu("Fritos"), sandwichSize);
            default -> {
                System.out.println("Invalid option.");
                addChips(_rec);
            }

        }
        System.out.println("Chips added to order.");
        processOrder(_rec);
    }

    public void processCheckout(Receipt _rec){
        System.out.println("Here is your order:");
        _rec.display();
        System.out.println("\nPlease confirm if the order is correct. Enter 1 for YES, 2 for NO.");
        System.out.print(">>");
        menuOption = read.nextInt();
        read.nextLine();

        while (true) {
            if (menuOption == 1) {
                ReceiptRecord.saveReceipt(_rec);
                break;
            } else if (menuOption==2) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        processHome();
    }

    public void exit(){
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
