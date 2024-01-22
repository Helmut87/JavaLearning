import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceNegativeTest {
    @Test
    void shouldReturnZeroForInactiveAccount() {
        AccountStatusChecker mockChecker = Mockito.mock(AccountStatusChecker.class);
        Mockito.when(mockChecker.isAccountActive(123L)).thenReturn(false);

        BonusService service = new BonusService(mockChecker);
        long amount = 10000;
        boolean isRegistered = true;

        long bonus = service.calculate(amount, isRegistered, 123L);
        assertEquals(0, bonus);
    }

    @Test
    void shouldHandleInvalidUserId() {
        AccountStatusChecker mockChecker = Mockito.mock(AccountStatusChecker.class);
        Mockito.when(mockChecker.isAccountActive(-1L)).thenReturn(false);

        BonusService service = new BonusService(mockChecker);
        long amount = 10000;
        boolean isRegistered = true;

        long bonus = service.calculate(amount, isRegistered, -1L);
        assertEquals(0, bonus);
    }
}
