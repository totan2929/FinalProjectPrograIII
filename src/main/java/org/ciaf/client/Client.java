package org.ciaf.client;

import org.ciaf.user.User;

public class Client extends User {
    private  int pointsFidelity;

    public Client(String name, String password) {
        super(name, password, rol);
        this.pointsFidelity = 0;
    }




    public int getPointsFidelity() {
        return pointsFidelity;
    }

    public void accumulatePoints(int points){
        this.pointsFidelity += points;
    }

    public boolean redeemPoints(int points){
        if (this.pointsFidelity >= points){
            this.pointsFidelity -= points;
            return true;
        } else{
            System.out.println("There are not enough points to redeem.");
            return false;
        }
    }
}
