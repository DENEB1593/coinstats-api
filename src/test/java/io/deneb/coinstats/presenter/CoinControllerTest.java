package io.deneb.coinstats.presenter;

import io.deneb.coinstats.model.Coin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoinControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void 코인_정보_조회시_응답_성공() {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("currency", "KRW");
        params.add("limit", "100");
        params.add("skip", "0");

        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(
                "/api/coins",
                ApiResponse.class,
                params
        );

        assertTrue(response.getStatusCode().is2xxSuccessful());
        List<Coin> coins = (List<Coin>) response.getBody().data();
        assertEquals(100, coins.size());

    }

}