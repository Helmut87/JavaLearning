package shop.people;

import shop.Person;

public class Adult extends Person {
    private boolean canBuyOnCredit;

    public Adult(String adultName, int adultMoney, int adultAge, boolean canBuyOnCredit) {
        super(adultName, adultMoney, adultAge);
        this.canBuyOnCredit = canBuyOnCredit;
    }

    public boolean isCanBuyOnCredit() {
        return canBuyOnCredit;
    }

    public void setCanBuyOnCredit(boolean canBuyOnCredit) {
        this.canBuyOnCredit = canBuyOnCredit;
    }
}
