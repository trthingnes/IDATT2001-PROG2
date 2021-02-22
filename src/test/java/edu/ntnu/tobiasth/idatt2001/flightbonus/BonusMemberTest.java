package edu.ntnu.tobiasth.idatt2001.flightbonus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@DisplayName("Bonus member tests")
public class BonusMemberTest {
  @Test
  @DisplayName("New members start with Basic membership")
  void newMembersStartWithBasicMembership() {
    BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");

    assert bm.getMembershipLevel().equals("Basic");
  }

  @Test
  @DisplayName("Membership changes to silver when limit is reached")
  void membershipChangesToSilverWhenLimitIsReached() {
    BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");
    bm.registerBonusPoints(25000);

    assert bm.getMembershipLevel().equals("Silver");
  }

  @Test
  @DisplayName("Membership does not change to silver before limit is reached")
  void membershipDoesNotChangeToSilverBeforeLimitIsReached() {
    BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");
    bm.registerBonusPoints(20000);

    assert bm.getMembershipLevel().equals("Basic");
  }

  @Test
  @DisplayName("Membership changes to gold when limit is reached")
  void membershipChangesToGoldWhenLimitIsReached() {
    BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");
    bm.registerBonusPoints(75000);

    assert bm.getMembershipLevel().equals("Gold");
  }

  @Test
  @DisplayName("Membership does not change to gold before limit is reached")
  void membershipDoesNotChangeToGoldBeforeLimitIsReached() {
    BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");
    bm.registerBonusPoints(70000);

    assert bm.getMembershipLevel().equals("Silver");
  }

  @Test
  @DisplayName("Member password has to match record to allow access")
  void memberPasswordHasToMatchRecordToAllowAccess() {
    MemberArchive ma = new MemberArchive();
    ma.addMember(new BonusMember(1, LocalDate.now(), "Name", "Email", "Password"));

    assert ma.findPoints(1, "password") == -1;
  }
}
