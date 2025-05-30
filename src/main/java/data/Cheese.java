package data;

public class Cheese extends Ingredient{

    private boolean isPremium = true;

    public Cheese(String _name, String[] _prices) {
        super(_name, _prices);
    }

    @Override
    public boolean isPremium() {
        return isPremium;
    }
}
