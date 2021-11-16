package pl.kohsin.currencycounter.domain.ports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kohsin.currencycounter.domain.model.Account;
import pl.kohsin.currencycounter.domain.model.ConvertedCurrency;
import pl.kohsin.currencycounter.domain.model.CurrencyRate;

import java.util.Currency;

@Service
@RequiredArgsConstructor
public final class CurrencyCounterService {

    private final AccountRepository accountRepository;
    private final CurrencyRateProvider currencyRateProvider;

    public ConvertedCurrency convertAccountBalance(String accountNumber, Currency targetCurrency) {

        Account account = accountRepository.getAccount(accountNumber);
        CurrencyRate actualCurrencyRate = currencyRateProvider.getActualCurrencyRate(account.getCurrency(), targetCurrency);
        return ConvertedCurrency.convert(account, actualCurrencyRate, targetCurrency);
    }
}
