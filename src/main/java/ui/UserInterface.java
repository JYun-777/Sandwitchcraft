package ui;

import data.ReceiptRecord;

import java.util.Scanner;

public class UserInterface {

    public static Scanner read = new Scanner(System.in);

    public void processHome(){

        System.out.print("Please enter an option:\n 1) New Order\n 0) Exit\n>>");
        int menuOption = read.nextInt();
        read.nextLine();

        switch (menuOption){
            case 1 -> System.out.println("Hey");//ReceiptRecord.saveReceipt();
            case 0 -> exit();
        }

    }

    public void processOrder(){

    }


    public void processCheckout(){

    }

    public void exit(){
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
