package data;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptRecord {

    private static FileWriter fw;

    public static void saveReceipt(Receipt _rec) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedTime = now.format(longFormat);
        try {
            fw = new FileWriter("Receipts/"+formattedTime+".txt");

            _rec.getReceiptEntryList().stream()
                            .forEach(entry -> {
                                try {
                                    fw.write(entry);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });

            fw.write("\nSaved at "+now.toString());



            fw.close();
        } catch (IOException e) {
            System.out.println("Receipt saving error.");
            throw new RuntimeException(e);
        }
    }
}
