package pl.kohsin.currencycounter.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Getter
public class ConvertedCurrency {
    private final BigDecimal amount;
    private final Currency currency;

    private ConvertedCurrency(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static ConvertedCurrency convert(Account account, CurrencyRate actualCurrencyRate, Currency destinationCurrency) throws InternalException {
        if (!account.getCurrency().equals(actualCurrencyRate.getSourceCurrency())) {
            throw new InternalException("Currency provider has returned currency rate for wrong source currency.");
        }
        if (!actualCurrencyRate.getTargetCurrency().equals(destinationCurrency)) {
            throw new InternalException("Currency provider has returned currency rate for wrong destination currency.");
        }
        final BigDecimal convertedValue = account.getAccountBalance().multiply(actualCurrencyRate.getCurrencyRate()).setScale(2, RoundingMode.DOWN);

        return new ConvertedCurrency(convertedValue, destinationCurrency);
    }
}
