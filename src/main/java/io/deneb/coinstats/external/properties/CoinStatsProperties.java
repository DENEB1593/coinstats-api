package io.deneb.coinstats.external.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * API 설정값을 저장한다.
 */
@ConfigurationProperties("api.coinstats")
public record CoinStatsProperties(String url) {
}
