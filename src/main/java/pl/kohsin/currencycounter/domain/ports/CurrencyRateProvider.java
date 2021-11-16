package pl.kohsin.currencycounter.domain.ports;

import pl.kohsin.currencycounter.domain.model.CurrencyRate;

import java.util.Currency;

public interface CurrencyRateProvider {
    CurrencyRate getActualCurrencyRate(Currency sourceCurrency, Currency targetCurrency);
}
