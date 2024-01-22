import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @Test
    void shouldReturnZeroForInactiveAccount() {
        AccountStatusChecker mockChecker = Mockito.mock(AccountStatusChecker.class);
        Mockito.when(mockChecker.isAccountActive(12345L)).thenReturn(false);

        BonusService service = new BonusService(mockChecker);
        long bonus = service.calculate(10000, true, 12345L);

        assertEquals(0, bonus);
    }

    @Test
    void shouldCalculateCorrectBonusForNonRegisteredUserWithActiveAccount() {
        AccountStatusChecker mockChecker = Mockito.mock(AccountStatusChecker.class);
        Mockito.when(mockChecker.isAccountActive(123L)).thenReturn(true);

        BonusService service = new BonusService(mockChecker);
        long amount = 10000;
        boolean isRegistered = false;
        long expectedBonus = 100;

        long bonus = service.calculate(amount, isRegistered, 123L);
        assertEquals(expectedBonus, bonus);
    }

    @Test
    void shouldCalculateCorrectBonusForRegisteredUserWithActiveAccount() {
        AccountStatusChecker mockChecker = Mockito.mock(AccountStatusChecker.class);
        Mockito.when(mockChecker.isAccountActive(123L)).thenReturn(true);

        BonusService service = new BonusService(mockChecker);
        long amount = 10000;
        boolean isRegistered = true;
        long expectedBonus = 300;

        long bonus = service.calculate(amount, isRegistered, 123L);
        assertEquals(expectedBonus, bonus);
    }

    @Test
    void shouldNotExceedMaximumLimitForActiveAccount() {
        AccountStatusChecker mockChecker = Mockito.mock(AccountStatusChecker.class);
        Mockito.when(mockChecker.isAccountActive(123L)).thenReturn(true);

        BonusService service = new BonusService(mockChecker);
        long amount = 20000;
        boolean isRegistered = true;
        long expectedBonus = 500;

        long bonus = service.calculate(amount, isRegistered, 123L);
        assertEquals(expectedBonus, bonus);
    }

    @Test
    void shouldCalculateSmallBonusForActiveAccount() {
        AccountStatusChecker mockChecker = Mockito.mock(AccountStatusChecker.class);
        Mockito.when(mockChecker.isAccountActive(123L)).thenReturn(true);

        BonusService service = new BonusService(mockChecker);
        long amount = 100;
        boolean isRegistered = false;
        long expectedBonus = 1;

        long bonus = service.calculate(amount, isRegistered, 123L);
        assertEquals(expectedBonus, bonus);
    }

    @Test
    void shouldReturnZeroForZeroAmountAndInactiveAccount() {
        AccountStatusChecker mockChecker = Mockito.mock(AccountStatusChecker.class);
        Mockito.when(mockChecker.isAccountActive(123L)).thenReturn(false);

        BonusService service = new BonusService(mockChecker);
        long amount = 0;
        boolean isRegistered = true;

        long bonus = service.calculate(amount, isRegistered, 123L);
        assertEquals(0, bonus);
    }
}