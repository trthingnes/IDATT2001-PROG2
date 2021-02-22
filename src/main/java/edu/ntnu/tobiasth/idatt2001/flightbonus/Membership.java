package edu.ntnu.tobiasth.idatt2001.flightbonus;

public abstract class Membership {
  /**
   * Apply membership multiplier to new bonus points.
   *
   * @param bonusPointBalance Current bonus point balance.
   * @param newPoints New points to register without multiplier.
   * @return New total bonus point balance.
   * @author trthingnes
   */
  public abstract int registerPoints(int bonusPointBalance, int newPoints);

  /**
   * Get membership name of the current membership level.
   *
   * @return Membership name word.
   * @author trthingnes
   */
  public abstract String getMembershipName();
}
