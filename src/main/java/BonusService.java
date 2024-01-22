public class BonusService {
    private AccountStatusChecker statusChecker;

    public BonusService(AccountStatusChecker statusChecker) {
        this.statusChecker = statusChecker;
    }
    public long calculate(long amount, boolean registered, long userId) {
        if (!statusChecker.isAccountActive(userId)) {
            return 0;
        }
        int percent = registered ? 3 : 1;
        long bonus = amount * percent / 100;
        long limit = 500;
        if (bonus > limit) {
            bonus = limit;
        }
        return bonus;
    }
}
