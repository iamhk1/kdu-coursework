package org.example.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Transactions {
    private String type;
    private Data data;

    // Getters and setters


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Data getData() {
        return data;
    }


    public void setData(Data data) {
        this.data = data;
    }

    // Data class within Transaction
    public static class Data {
        private String coin;
        private Long quantity;
        @JsonProperty("wallet_address")
        private String walletAddress;
        private Double price;
        private Long volume; // Added "volume" property

        // Getters and setters


        public String getCoin() {
            return coin;
        }


        public void setCoin(String coin) {
            this.coin = coin;
        }


        public Long getQuantity() {
            return quantity;
        }


        public void setQuantity(Long quantity) {
            this.quantity = quantity;
        }


        public String getWalletAddress() {
            return walletAddress;
        }


        public void setWalletAddress(String walletAddress) {
            this.walletAddress = walletAddress;
        }


        public Double getPrice() {
            return price;
        }


        public void setPrice(Double price) {
            this.price = price;
        }


        public Long getVolume() {
            return volume;
        }


        public void setVolume(Long volume) {
            this.volume = volume;
        }
    }
}
