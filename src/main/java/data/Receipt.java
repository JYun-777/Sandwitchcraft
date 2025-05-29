package data;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private List<Orderable> itemList = new ArrayList<>();
    private List<Double> priceList = new ArrayList<>();
    private double totalPrice = 0;

    public void addToReceipt(Orderable _order, int _sizeIndex){
        itemList.add(_order);
        double itemPrice = _order.choosePrice(_sizeIndex);
        priceList.add(itemPrice);
        totalPrice += itemPrice;
    }

    public void display(){
        System.out.printf("%-15s|%-15s","Item", "Price");
        for(int i = 0; i < itemList.size(); i++){
            System.out.printf("%-15s|%-15f\n", itemList.get(i).getName(), priceList.get(i));
        }

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
}
