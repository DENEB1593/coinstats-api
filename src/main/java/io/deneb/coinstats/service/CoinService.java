package io.deneb.coinstats.service;

import io.deneb.coinstats.external.client.CoinStatsApiClient;
import io.deneb.coinstats.model.Coin;
import io.deneb.coinstats.presenter.CoinRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    private final CoinStatsApiClient client;
    private final Logger log = LoggerFactory.getLogger(CoinService.class);

    public CoinService(CoinStatsApiClient client) {
        this.client = client;
    }

    public List<Coin> getCoins(CoinRequest request) {
        // TODO Coin 모델로 변환 필요
        String coins = client.getCoins(
                request.currency(),
                request.limit(),
                request.skip());
        return null;
    }
}
