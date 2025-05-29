package data;

public class Ingredient extends Orderable{
    private String name;
    private String[] prices;

    public Ingredient (String _name, String[] _prices){
        this.name = _name;
        this.prices = _prices;
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
