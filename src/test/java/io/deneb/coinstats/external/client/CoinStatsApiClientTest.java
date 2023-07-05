package io.deneb.coinstats.external.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoinStatsApiClientTest {

    @Autowired
    CoinStatsApiClient client;

    @Test
    void 한화기준으로_코인을_조회한다() {
        String result = "";

        assertDoesNotThrow(() -> client.getCoins("KRW", 100, 0));
        assertNotNull(result);
    }

}