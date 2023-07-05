package io.deneb.coinstats.external.model;

import io.deneb.coinstats.model.Coin;

import java.util.List;

public record CoinStatsApiResponse(List<Coin> coins) {
}
