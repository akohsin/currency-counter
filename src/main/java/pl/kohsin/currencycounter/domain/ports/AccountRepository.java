package pl.kohsin.currencycounter.domain.ports;

import pl.kohsin.currencycounter.domain.model.Account;

public interface AccountRepository {

    Account getAccount(String accountNumber);
}
