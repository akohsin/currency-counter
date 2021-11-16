package pl.kohsin.currencycounter.adapters.api;

import lombok.Getter;
import pl.kohsin.currencycounter.domain.model.ConvertedCurrency;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
class ConvertAccountBalanceResponse {
    private final BigDecimal convertedAccountBalance;
    private final Currency currency;

    static ConvertAccountBalanceResponse of(ConvertedCurrency convertedCurrency, Currency destinationCurrency) {
        return new ConvertAccountBalanceResponse(convertedCurrency.getAmount(), destinationCurrency);
    }

    private ConvertAccountBalanceResponse(BigDecimal convertedAccountBalance, Currency currency) {
        this.convertedAccountBalance = convertedAccountBalance;
        this.currency = currency;
    }

}
