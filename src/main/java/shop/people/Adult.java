package shop.people;

import shop.Person;
import shop.Product;

import java.util.ArrayList;

public class Adult extends Person {
    private boolean canBuyOnCredit;

    public Adult(String adultName, int adultAge, int adultMoney, boolean canBuyOnCredit, ArrayList<Product> personShoppingCart) {
        super(adultName, adultMoney, adultAge, personShoppingCart);
        this.canBuyOnCredit = canBuyOnCredit;
    }

    public boolean isCanBuyOnCredit() {
        return canBuyOnCredit;
    }

    public void setCanBuyOnCredit(boolean canBuyOnCredit) {
        this.canBuyOnCredit = canBuyOnCredit;
    }
}
