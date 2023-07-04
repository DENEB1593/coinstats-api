package io.deneb.coinstats.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfiguration {

    /**
     * coinStats API용 restTemplate을 설정한다.
     */
    @Bean
    RestTemplate coinStatsRestTemplate() {
        return new RestTemplateBuilder()
                .setReadTimeout(Duration.ofSeconds(5))
                .setConnectTimeout(Duration.ofSeconds(5))
                .build();
    }

}
