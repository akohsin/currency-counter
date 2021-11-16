package pl.kohsin.currencycounter.adapters.exhangeRateProvider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NbpRate {

    private String no;
    private LocalDate effectiveDate;
    private BigDecimal mid;
}
