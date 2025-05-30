package data;

public class Meat extends Ingredient{

    private boolean isPremium = true;


    public Meat(String _name, String[] _prices) {
        super(_name, _prices);
    }

    @Override
    public boolean isPremium() {
        return isPremium;
    }
}
