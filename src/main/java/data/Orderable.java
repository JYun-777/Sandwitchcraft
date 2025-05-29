package data;

public abstract class Orderable {
    private String name;
    private String[] prices;

    //selects price based on size
    public double choosePrice(int sizeIndex){
        return Double.parseDouble(this.getPrices()[sizeIndex]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String[] getPrices() {
        return prices;
    }

    public void setPrices(String[] prices) {
        this.prices = prices;
    }
}
