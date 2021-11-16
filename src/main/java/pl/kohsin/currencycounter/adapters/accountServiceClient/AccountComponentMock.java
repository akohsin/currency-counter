package pl.kohsin.currencycounter.adapters.accountServiceClient;

import org.springframework.stereotype.Component;
import pl.kohsin.currencycounter.domain.model.Account;
import pl.kohsin.currencycounter.domain.ports.AccountRepository;

import java.math.BigDecimal;
import java.util.Currency;

@Component
public class AccountComponentMock implements AccountRepository {

    @Override
    public Account getAccount(String accountNumber) {
        return Account.of(accountNumber, BigDecimal.valueOf(500L), Currency.getInstance("PLN"));
    }
}
