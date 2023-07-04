package io.deneb.coinstats.external.client;

import io.deneb.coinstats.external.enums.ApiQueryParameter;
import io.deneb.coinstats.external.properties.CoinStatsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 가상화폐 API 통신을 한다.
 */
@Slf4j
@Component
public class CoinStatsApiClient {

    private final RestTemplate restTemplate;
    private final CoinStatsProperties properties;

    public CoinStatsApiClient(
            @Qualifier("coinStatsRestTemplate") RestTemplate restTemplate,
            CoinStatsProperties properties) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    /**
     * 가상화폐의 정보를 조회한다.
     */
    public String getCoins() {

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(properties.url())
                .queryParam(ApiQueryParameter.CoinStats.getCurrency(), "")
                .queryParam(ApiQueryParameter.CoinStats.getLimit(), "")
                .queryParam(ApiQueryParameter.CoinStats.getSkip(), "")
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    uriComponents.toUri(),
                    HttpMethod.GET,
                    entity,
                    String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            log.error("API 통신오류: {}", e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }

    }
}
