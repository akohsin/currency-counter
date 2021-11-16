package pl.kohsin.currencycounter.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
public class Account {
    private final String accountNumber;
    private final BigDecimal accountBalance;
    private final Currency currency;

    public static Account of(String accountNumber, BigDecimal accountBalance, Currency currency) {
        return new Account(accountNumber, accountBalance, currency);
    }

    private Account(String accountNumber, BigDecimal accountBalance, Currency currency) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
