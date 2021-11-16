package pl.kohsin.currencycounter.adapters.exhangeRateProvider;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kohsin.currencycounter.domain.model.InternalException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

@Component
@RequiredArgsConstructor
class NbpApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    BigDecimal getActualCurrencyRate(Currency destinationCurrency) {
        String GET_ACTUAL_AVG_RATE = "http://api.nbp.pl/api/exchangerates/rates/";
        String TABLE_A = "A";

        final RequestEntity<Void> requestEntity = RequestEntity.get(GET_ACTUAL_AVG_RATE + TABLE_A + "/" + destinationCurrency.getCurrencyCode())
                .accept(MediaType.APPLICATION_JSON)
                .build();
        try {
            final ResponseEntity<NbpActualCurrencyResponse> exchange = restTemplate.exchange(requestEntity, NbpActualCurrencyResponse.class);
            return Objects.requireNonNull(exchange.getBody()).getRates().get(0).getMid();
        }catch (Exception e){
            throw new InternalException("Couldn't get actual currency rate");
        }
    }
}
