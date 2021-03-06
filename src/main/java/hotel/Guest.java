package hotel;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

public class Guest {

    private String name;
    private double wallet;

    public Guest(String name, double wallet){
        if(wallet < 0){
            throw new IllegalArgumentException("Wallet must be positive");
        }
        this.name = name;
        this.wallet = wallet;
    }

    public String getName(){
        return name;
    }

    public double getWallet(){
        return wallet;
    }

    public void addFunds(double amount){
        if(amount > 0){
            wallet += amount;
        }
    }

    public void reduceFunds(double amount){
        if(canAfford(amount)){
            wallet -= amount;
        }
    }

    public boolean canAfford(double amount){
        return amount >= 0 && amount <= wallet;
    }
}
