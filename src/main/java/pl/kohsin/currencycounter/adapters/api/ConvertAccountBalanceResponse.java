package pl.kohsin.currencycounter.adapters.api;

import lombok.Getter;
import pl.kohsin.currencycounter.domain.model.ConvertedCurrency;

import java.math.BigDecimal;

@Getter
class ConvertAccountBalanceResponse {
    private final BigDecimal convertedAccountBalance;

    static ConvertAccountBalanceResponse of(ConvertedCurrency convertedCurrency) {
        return new ConvertAccountBalanceResponse(convertedCurrency.getAmount());
    }

    private ConvertAccountBalanceResponse(BigDecimal convertedAccountBalance) {
        this.convertedAccountBalance = convertedAccountBalance;
    }

}
