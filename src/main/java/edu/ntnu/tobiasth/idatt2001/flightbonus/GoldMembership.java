package edu.ntnu.tobiasth.idatt2001.flightbonus;

public class GoldMembership extends Membership {

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        float POINT_SCALING_FACTOR;

        if(bonusPointBalance < 90000) {
            POINT_SCALING_FACTOR = 1.3f;
        }
        else {
             POINT_SCALING_FACTOR = 1.5f;
        }

        return Math.round(bonusPointBalance + (newPoints * POINT_SCALING_FACTOR));
    }

    @Override
    public String getMembershipName() {
        return "Gold";
    }
}
