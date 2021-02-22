package edu.ntnu.tobiasth.idatt2001.flightbonus;

public class BasicMembership extends Membership {
  /**
   * Apply membership multiplier to new bonus points.
   *
   * @param bonusPointBalance Current bonus point balance.
   * @param newPoints New points to register without multiplier.
   * @return New total bonus point balance.
   * @author trthingnes
   */
  @Override
  public int registerPoints(int bonusPointBalance, int newPoints) {
    return bonusPointBalance + newPoints;
  }

  /**
   * Get membership name of the current membership level.
   *
   * @return Membership name word.
   * @author trthingnes
   */
  @Override
  public String getMembershipName() {
    return "Basic";
  }
}
