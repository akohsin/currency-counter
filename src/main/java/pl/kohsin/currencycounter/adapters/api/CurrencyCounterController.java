package pl.kohsin.currencycounter.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequestMapping("/currencyCounter/")
@RequiredArgsConstructor
public class CurrencyCounterController {

    private final CurrencyCounterApiService currencyCounterApiService;

    @GetMapping(value = "convertBalanceToEuro", produces = "application/json")
    @ResponseStatus( HttpStatus.OK )
    public ConvertAccountBalanceResponse convertAccountBalance(@RequestParam String accountNumber){
        return currencyCounterApiService.convertAccountBalance(accountNumber, Currency.getInstance("EUR"));
    }

}
