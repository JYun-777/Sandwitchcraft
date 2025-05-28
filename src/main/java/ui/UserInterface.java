package ui;

import java.util.Scanner;

public class UserInterface {

    public static Scanner read = new Scanner(System.in);

    public static void processHome(){

        System.out.print("Please enter an option:\n 1) New Order\n 0) Exit\n>>");
        int menuOption = read.nextInt();
        read.nextLine();

        switch (menuOption){
            case 1 -> System.out.println("new order");
            case 0 -> exit();
        }

    }

    public static void processOrder(){

    }

    public static void processOrder(){

    }

    public static void processCheckout(){

    }

    public static void exit(){
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
