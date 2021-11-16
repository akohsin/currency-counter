package pl.kohsin.currencycounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.kohsin.currencycounter.domain.model.Account;
import pl.kohsin.currencycounter.domain.model.ConvertedCurrency;
import pl.kohsin.currencycounter.domain.model.CurrencyRate;
import pl.kohsin.currencycounter.domain.ports.AccountRepository;
import pl.kohsin.currencycounter.domain.ports.CurrencyCounterService;
import pl.kohsin.currencycounter.domain.ports.CurrencyRateProvider;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@SpringBootTest
class CurrencyCounterApplicationTests {

    @MockBean
    CurrencyRateProvider currencyRateProvider;

    @MockBean
    AccountRepository accountRepository;

    @Autowired
    private CurrencyCounterService currencyCounterService;

    @Test
    void contextLoads() {
    }

    @Test
    public void currencyCounterConvertPositiveTest(){
        BigDecimal midRate = BigDecimal.valueOf(4.62);
        BigDecimal plnToEurCurrencyRate = BigDecimal.ONE.divide(midRate, 8, RoundingMode.DOWN);
        Currency eur = Currency.getInstance("EUR");
        Currency pln = Currency.getInstance("PLN");
        BigDecimal accountBalance = BigDecimal.valueOf(500);

        Mockito.when(currencyRateProvider.getActualCurrencyRate(pln, eur)).thenReturn(CurrencyRate.of(plnToEurCurrencyRate, pln, eur));
        Mockito.when(accountRepository.getAccount(Mockito.anyString())).thenReturn(Account.of("123", accountBalance, pln));

        BigDecimal expectedBalance = accountBalance.multiply(plnToEurCurrencyRate).setScale(2, RoundingMode.DOWN);

        ConvertedCurrency testedResult = currencyCounterService.convertAccountBalance("123", eur);
        Assertions.assertEquals(expectedBalance, testedResult.getAmount());
        Assertions.assertEquals(eur, testedResult.getCurrency());

        accountBalance = BigDecimal.valueOf(600);

        Mockito.when(currencyRateProvider.getActualCurrencyRate(pln, eur)).thenReturn(CurrencyRate.of(plnToEurCurrencyRate, pln, eur));
        Mockito.when(accountRepository.getAccount(Mockito.anyString())).thenReturn(Account.of("123", accountBalance, pln));

        expectedBalance = accountBalance.multiply(plnToEurCurrencyRate).setScale(2, RoundingMode.DOWN);

        testedResult = currencyCounterService.convertAccountBalance("123", eur);
        Assertions.assertEquals(expectedBalance, testedResult.getAmount());
        Assertions.assertEquals(eur, testedResult.getCurrency());
    }
}
