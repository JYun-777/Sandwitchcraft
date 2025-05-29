package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuPriceReader {
    private ArrayList<Ingredient> ingredientList= new ArrayList<>();

    public MenuPriceReader() {
        try {
            FileReader fr = new FileReader("Resources/MenuPrices.csv");
            BufferedReader br = new BufferedReader(fr);

            String dataLine;
            String[] dataFields;

            while ((dataLine = br.readLine()) != null){
                dataFields = dataLine.split("\\|");
                ingredientList.add(new Ingredient(dataFields[0], new String[]{dataFields[1],dataFields[2],dataFields[3]}));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("File format incompatible.");
            throw new RuntimeException(e);
        }
    }

    public void parseFileLine(){

    }

    //public String[] readNames(int section){

    //}

}
