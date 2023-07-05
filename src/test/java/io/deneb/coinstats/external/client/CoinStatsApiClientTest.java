package io.deneb.coinstats.external.client;

import io.deneb.coinstats.external.model.CoinStatsApiResponse;
import io.deneb.coinstats.model.Coin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoinStatsApiClientTest {

    @Autowired
    CoinStatsApiClient client;

    @Test
    void 한화기준으로_코인을_조회한다() {
        CoinStatsApiResponse result = client.getCoins("KRW", 100, 0);

        assertNotNull(result);
        List<Coin> coins = result.coins();

        assertNotNull(coins);
        assertEquals(coins.size(), 100);
    }

}