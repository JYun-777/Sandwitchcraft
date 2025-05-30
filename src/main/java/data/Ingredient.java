package data;

public class Ingredient extends Orderable{
    private boolean isPremium = false;

    public Ingredient (String _name, String[] _prices){
        this.name = _name;
        this.prices = _prices;
    }

    public boolean isPremium() {
        return isPremium;
    }
}
