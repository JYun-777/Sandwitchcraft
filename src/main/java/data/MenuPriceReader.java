package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.HashMap;

public class MenuPriceReader {
    private HashMap<String, String[]> menuPriceList = new HashMap<>();
    private FileReader fr = new FileReader("src/main/Resources/MenuPrices.csv");
    private BufferedReader br = new BufferedReader(fr);
    public MenuPriceReader() {

    }

}
