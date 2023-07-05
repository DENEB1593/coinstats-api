package io.deneb.coinstats.presenter;

public record CoinRequest(
        String currency, Integer limit, Integer skip ) {
}
