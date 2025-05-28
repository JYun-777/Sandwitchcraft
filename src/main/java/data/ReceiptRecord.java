package data;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptRecord {

    private FileWriter fw;

    public void saveReceipt() {
        try {
            fw = new FileWriter("src/main/Receipts");
        } catch (IOException e) {
            System.out.println("Receipt saving error.");
            throw new RuntimeException(e);
        }
    }
}
