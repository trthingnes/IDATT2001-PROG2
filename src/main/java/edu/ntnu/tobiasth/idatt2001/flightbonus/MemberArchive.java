package edu.ntnu.tobiasth.idatt2001.flightbonus;

import java.time.LocalDate;
import java.util.HashMap;

public class MemberArchive {
  HashMap<Integer, BonusMember> members = new HashMap<>();

  /**
   * Get the number of points a member with the given number has.
   *
   * @param memberNumber Member number.
   * @param password Member password.
   * @return Number of points if member exists and password is correct, and -1 if not.
   * @author trthingnes
   */
  public int findPoints(int memberNumber, String password) {
    if (!(members.containsKey(memberNumber) && members.get(memberNumber).checkPassword(password))) {
      return -1;
    }

    return members.get(memberNumber).getBonusPointsBalance();
  }

  /**
   * Register new points for the given user.
   *
   * @param memberNumber Member number.
   * @param newPoints New points to add.
   * @return True if points added, false if not.'
   * @author trthingnes
   */
  public boolean registerPoints(int memberNumber, int newPoints) {
    if (!members.containsKey(memberNumber)) {
      return false;
    }

    members.get(memberNumber).registerBonusPoints(newPoints);
    return true;
  }

  /**
   * Add a new bonus member to the archive.
   *
   * @param bonusMember Bonus member to add.
   * @return Member number if member is added, -1 if member with given number already exists.
   * @author trthingnes
   */
  public int addMember(BonusMember bonusMember) {
    if (members.containsKey(bonusMember.getMemberNumber())) {
      return -1;
    }

    members.put(bonusMember.getMemberNumber(), bonusMember);
    return bonusMember.getMemberNumber();
  }

  /**
   * Prints a list of all members to the console.
   *
   * @author trthingnes
   */
  public void listAllMembers() {
    for (BonusMember bonusMember : members.values()) {
      System.out.println(bonusMember.toString());
    }
  }

  protected void addDummyData() {
    members.put(
        1, new BonusMember(1, LocalDate.parse("2000-10-04"), "Tobias", "tobias@tobi.as", "saiboT"));
    members.put(
        2, new BonusMember(2, LocalDate.parse("2001-11-14"), "Pål", "pal@online.no", "låP"));
    members.put(3, new BonusMember(3, LocalDate.parse("2010-07-04"), "Ina", "ina@vg.no", "anI"));
    members.put(
        4, new BonusMember(4, LocalDate.parse("2012-01-15"), "Rolf", "rolf.inge@elko.no", "floR"));
    members.put(
        5,
        new BonusMember(
            5, LocalDate.parse("2021-01-30"), "Susanne", "bb84life@ntebb.no", "ennasuS"));
  }
}
