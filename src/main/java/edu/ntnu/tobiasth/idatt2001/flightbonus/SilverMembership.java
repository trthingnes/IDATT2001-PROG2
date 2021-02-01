package edu.ntnu.tobiasth.idatt2001.flightbonus;

public class SilverMembership extends Membership {
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        float POINT_SCALING_FACTOR = 1.2f;
        return Math.round(bonusPointBalance + (newPoints * POINT_SCALING_FACTOR));
    }

    @Override
    public String getMembershipName() {
        return "Silver";
    }
}
