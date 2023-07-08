package io.deneb.coinstats.external.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.deneb.coinstats.exception.ApiErrorException;
import io.deneb.coinstats.external.enums.ApiQueryParameter;
import io.deneb.coinstats.external.model.CoinStatsApiResponse;
import io.deneb.coinstats.external.properties.CoinStatsProperties;
import io.deneb.coinstats.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Component
public class CoinStatsApiClient {

    private static final Logger log = LoggerFactory.getLogger(CoinStatsApiClient.class);
    private final RestTemplate restTemplate;
    private final CoinStatsProperties properties;
    private final JsonUtils jsonUtils;

    public CoinStatsApiClient(
            @Qualifier("coinStatsRestTemplate") RestTemplate restTemplate,
            CoinStatsProperties properties,
            JsonUtils jsonUtils) {
        this.properties = properties;
        this.restTemplate = restTemplate;
        this.jsonUtils = jsonUtils;
    }

    /**
     * 가상화폐의 정보를 조회한다.
     */
    public CoinStatsApiResponse getCoins(String currency, Integer limit, Integer skip) {

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(properties.url())
                .queryParam(ApiQueryParameter.CoinStats.getCurrency(), currency)
                .queryParam(ApiQueryParameter.CoinStats.getLimit(), limit)
                .queryParam(ApiQueryParameter.CoinStats.getSkip(), skip)
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
            return jsonUtils.stringToObj(response.getBody(), CoinStatsApiResponse.class);
        } catch (HttpClientErrorException e) {
            log.error("Api call error: {}", e.getMessage(), e);
            throw new ApiErrorException("코인 조회에 실패하였습니다.");
        }

    }
}
