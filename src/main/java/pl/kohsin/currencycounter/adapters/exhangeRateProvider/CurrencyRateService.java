package pl.kohsin.currencycounter.adapters.exhangeRateProvider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kohsin.currencycounter.domain.model.CurrencyRate;
import pl.kohsin.currencycounter.domain.model.InternalException;
import pl.kohsin.currencycounter.domain.ports.CurrencyRateProvider;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Component
@RequiredArgsConstructor
public class CurrencyRateService implements CurrencyRateProvider {

    private final NbpApiClient nbpApiClient;

    @Override
    public CurrencyRate getActualCurrencyRate(Currency sourceCurrency, Currency targetCurrency) {
        if (Currency.getInstance("PLN").equals(sourceCurrency)) {
            final BigDecimal midRate = nbpApiClient.getActualCurrencyRate(targetCurrency);
            final BigDecimal currencyRate = BigDecimal.ONE.divide(midRate, 10, RoundingMode.HALF_UP);
            return CurrencyRate.of(currencyRate, sourceCurrency, targetCurrency);

        } else if (Currency.getInstance("PLN").equals(targetCurrency)) {
            final BigDecimal midRate = nbpApiClient.getActualCurrencyRate(targetCurrency);
            return CurrencyRate.of(midRate, sourceCurrency, targetCurrency);
        } else {
            throw new InternalException("Currency not supported");
        }
    }
}
