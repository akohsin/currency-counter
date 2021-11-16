package pl.kohsin.currencycounter.adapters.exhangeRateProvider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Currency;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NbpActualCurrencyResponse {

    private String table;
    private String currency;
    private Currency code;
    private List<NbpRate> rates;

}
