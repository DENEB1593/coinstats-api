package io.deneb.coinstats.presenter;

import io.deneb.coinstats.model.Coin;
import io.deneb.coinstats.service.CoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/coins")
public class CoinController {
    private static final Logger log = LoggerFactory.getLogger(CoinController.class);
    private final CoinService service;

    public CoinController(CoinService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<Coin>> getCoins(CoinRequest request) {
        return ApiResponse.ok(
                service.getCoins(request));

    }
}
