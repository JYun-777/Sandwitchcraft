package data;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private List<Orderable> itemList = new ArrayList<>();
    private List<Double> priceList = new ArrayList<>();
    private double totalPrice = 0;
    private int sandwichCount = 0;
    private List<String> receiptEntryList = new ArrayList<>();

    public void addToReceipt(Orderable _order, int _sizeIndex){
        itemList.add(_order);
        double itemPrice = _order.choosePrice(_sizeIndex);
        priceList.add(itemPrice);
        totalPrice += itemPrice;
    }

    public void display(){
        String header = String.format("%-15s|%-15s\n","Item", "Price");
        receiptEntryList.add(header);
        System.out.printf(header);
        for(int i = 0; i < itemList.size(); i++){
            String entry = String.format("%-15s|%-15.2f\n", itemList.get(i).getName(), priceList.get(i));
            System.out.printf(entry);
            receiptEntryList.add(entry);
        }
        String total = String.format("%-16s%-15.2f", "TOTAL:", totalPrice);
        System.out.printf(total);
        receiptEntryList.add(total);
    }

    public List<Orderable> getItemList() {
        return itemList;
    }

    public void setItemList(List<Orderable> itemList) {
        this.itemList = itemList;
    }

    public List<Double> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Double> priceList) {
        this.priceList = priceList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<String> getReceiptEntryList() {
        return receiptEntryList;
    }
}
