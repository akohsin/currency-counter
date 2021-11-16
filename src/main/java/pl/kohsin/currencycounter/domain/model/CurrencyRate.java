package pl.kohsin.currencycounter.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
public class CurrencyRate {
    private final BigDecimal currencyRate;
    private final Currency sourceCurrency;
    private final Currency targetCurrency;

    public static CurrencyRate of(BigDecimal currencyRate, Currency sourceCurrency, Currency targetCurrency) {
        return new CurrencyRate(currencyRate, sourceCurrency, targetCurrency);
    }

    private CurrencyRate(BigDecimal currencyRate, Currency sourceCurrency, Currency targetCurrency) {
        this.currencyRate = currencyRate;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
    }
}
