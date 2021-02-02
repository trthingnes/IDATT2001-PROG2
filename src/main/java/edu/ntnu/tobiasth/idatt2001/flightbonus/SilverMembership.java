package edu.ntnu.tobiasth.idatt2001.flightbonus;

public class SilverMembership extends Membership {
    /**
     * Apply membership multiplier to new bonus points.
     * @param bonusPointBalance Current bonus point balance.
     * @param newPoints New points to register without multiplier.
     * @return New total bonus point balance.
     * @author trthingnes
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        final float POINT_SCALING_FACTOR = 1.2f;
        return Math.round(bonusPointBalance + (newPoints * POINT_SCALING_FACTOR));
    }

    /**
     * Get membership name of the current membership level.
     * @return Membership name word.
     * @author trthingnes
     */
    @Override
    public String getMembershipName() {
        return "Silver";
    }
}
