package pl.kohsin.currencycounter.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kohsin.currencycounter.domain.model.ConvertedCurrency;
import pl.kohsin.currencycounter.domain.ports.CurrencyCounterService;

import java.util.Currency;

@Service
@RequiredArgsConstructor
public class CurrencyCounterApiService {

    private final CurrencyCounterService currencyCounterService;

    public ConvertAccountBalanceResponse convertAccountBalance(String accountNumber, Currency destinationCurrency) {
        ConvertedCurrency convertedCurrency = currencyCounterService.convertAccountBalance(accountNumber, destinationCurrency);
        return ConvertAccountBalanceResponse.of(convertedCurrency);
    }
}
