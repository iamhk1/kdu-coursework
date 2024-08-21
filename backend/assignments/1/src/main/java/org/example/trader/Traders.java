package org.example.trader;

import java.util.HashMap;

public class Traders {
        private  String firstName;
        private String lastName;
        private String walletAddress;
        private String phoneNo;
        private  long profit;
        private  HashMap<String,Long>portfolio;
        public Traders()
        {

        }

        public Traders(String firstName, String lastName, String phoneNo, String walletAddress)
        {
            this.firstName=firstName;
            this.lastName=lastName;
            this.walletAddress=walletAddress;
            this.phoneNo=phoneNo;
            this.profit=0;
            portfolio=new HashMap<>();
        }
        public  HashMap<String,Long> getPortfolio()
        {
            return portfolio;
        }

        public long getProfit()
        {
            return this.profit;

        }
    public  String getFirstName() {
        return firstName;
    }

    public  String getLastName() {
        return lastName;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }




}
