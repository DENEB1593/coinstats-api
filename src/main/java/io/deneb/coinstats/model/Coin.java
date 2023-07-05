package io.deneb.coinstats.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coin {
    private String id;
    private String icon;
    private String name;
    private String symbol;
    private int rank;
    private double price;
    private int priceBtc;
    private String websiteUrl;
    private List<String> exp;
}

/*
{
    "id": "bitcoin",
    "icon": "https://api.coin-stats.com/api/files/812fde17aea65fbb9f1fd8a478547bde/f3738cc5df5f59afb57111d67d951170_1.png",
    "name": "Bitcoin",
    "symbol": "BTC",
    "rank": 1,
    "price": 6362.74960614,
    "priceBtc": 1,
    "volume": 4514555849.85,
    "marketCap": 110545616313,
    "availableSupply": 17373875,
    "totalSupply": 17373875,
    "priceChange1h": 0.12,
    "priceChange1d": -0.56,
    "priceChange1w": -1.07,
    "websiteUrl": "https://bitcoin.org",
    "redditUrl": "https://www.reddit.com/r/bitcoin",
    "twitterUrl": "https://twitter.com/btc",
    "exp": [
      "https://blockchain.info/",
      "https://live.blockcypher.com/btc/",
      "https://blockchair.com/bitcoin/blocks"
    ]
  }
  */
