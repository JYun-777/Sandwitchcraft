package data;

public abstract class Orderable {
    private String name;
    private String[] prices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //selects price based on size
    public double choosePrice(int sizeIndex){
        return Double.parseDouble(this.getPrices()[sizeIndex]);
    }

    public String[] getPrices() {
        return prices;
    }

    public void setPrices(String[] prices) {
        this.prices = prices;
    }
}
