package data;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptRecord {

    private FileWriter fw;

    public void saveReceipt() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedTime = now.format(longFormat);
        try {

            fw = new FileWriter("src/main/Receipts"+"/"+formattedTime+".txt");
            fw.write("Saved at "+now.toString());

            fw.close();
        } catch (IOException e) {
            System.out.println("Receipt saving error.");
            throw new RuntimeException(e);
        }
    }
}
