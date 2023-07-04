package io.deneb.coinstats.external.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CoinStatsPropertiesTest {

    @Autowired
    CoinStatsProperties properties;

    @Test
    void 설정값을_확인한다() {
        assertNotNull(properties);
        assertNotNull(properties.url());
    }

}