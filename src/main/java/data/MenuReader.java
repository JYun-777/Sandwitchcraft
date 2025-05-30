package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuReader {

    private List<Ingredient> ingredientList= new ArrayList<>();
    private String ingredientType = "Ingredient";

    public MenuReader() {
        try {
            FileReader fr = new FileReader("Resources/MenuPrices.csv");
            BufferedReader br = new BufferedReader(fr);

            String dataLine;
            String[] dataFields;

            while ((dataLine = br.readLine()) != null){
                dataFields = dataLine.split("\\|");
                if (dataFields[1].equals("Meats")) {
                    ingredientType = "Meats";
                }else if (dataFields[1].equals("Cheese")) {
                    ingredientType = "Cheese";
                }else if (dataFields[1].equals("Bread")||dataFields[1].equals("Regular Toppings")){
                    ingredientType = "Ingredient";
                }

                switch (ingredientType){
                    case "Meats" -> ingredientList.add(new Meat(dataFields[0], new String[]{dataFields[1],dataFields[2],dataFields[3]}));
                    case "Cheese" -> ingredientList.add(new Cheese(dataFields[0], new String[]{dataFields[1],dataFields[2],dataFields[3]}));
                    case "Ingredient" -> ingredientList.add(new Ingredient(dataFields[0], new String[]{dataFields[1],dataFields[2],dataFields[3]}));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("File format incompatible.");
            throw new RuntimeException(e);
        }
    }

    public Orderable searchMenu(String _name){

        try {
            List<Ingredient> match = ingredientList.stream()
                    .filter( ing -> ing.getName().contains(_name))
                    .toList();

            return match.getFirst();
        } catch (Exception e) {
            System.out.println("Invalid selection, try again");
            return null;
        }
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
