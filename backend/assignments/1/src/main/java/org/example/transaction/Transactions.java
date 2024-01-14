package org.example.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Transactions {
    private String type;
    private Data data;

    // Getters and setters

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    // Data class within Transaction
    public static class Data {
        private String coin;
        private Long quantity;
        private String walletAddress;
        private Double price;
        private Long volume; // Added "volume" property

        // Getters and setters

        @JsonProperty("org/example/coin")
        public String getCoin() {
            return coin;
        }

        @JsonProperty("org/example/coin")
        public void setCoin(String coin) {
            this.coin = coin;
        }

        @JsonProperty("quantity")
        public Long getQuantity() {
            return quantity;
        }

        @JsonProperty("quantity")
        public void setQuantity(Long quantity) {
            this.quantity = quantity;
        }

        @JsonProperty("wallet_address")
        public String getWalletAddress() {
            return walletAddress;
        }

        @JsonProperty("wallet_address")
        public void setWalletAddress(String walletAddress) {
            this.walletAddress = walletAddress;
        }

        @JsonProperty("price")
        public Double getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(Double price) {
            this.price = price;
        }

        @JsonProperty("volume")
        public Long getVolume() {
            return volume;
        }

        @JsonProperty("volume")
        public void setVolume(Long volume) {
            this.volume = volume;
        }
    }
}
