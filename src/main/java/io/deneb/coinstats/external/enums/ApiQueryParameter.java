package io.deneb.coinstats.external.enums;

/**
 * API 송신에 필요한 query 변수를 정의한다.
 */
public enum ApiQueryParameter {

    CoinStats("currency", "limit",  "skip");

    private final String currency;
    private final String limit;
    private final String skip;


    ApiQueryParameter(
            String currency, String limit, String skip) {
        this.currency = currency;
        this.limit = limit;
        this.skip = skip;
    }

    public String getCurrency() {
        return currency;
    }

    public String getLimit() {
        return limit;
    }

    public String getSkip() {
        return skip;
    }
}
