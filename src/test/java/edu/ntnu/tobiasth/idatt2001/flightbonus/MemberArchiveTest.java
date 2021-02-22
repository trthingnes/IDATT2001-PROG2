package edu.ntnu.tobiasth.idatt2001.flightbonus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@DisplayName("Member archive tests")
public class MemberArchiveTest {
  @Test
  @DisplayName("Members can be added")
  void membersCanBeAdded() {
    MemberArchive ma = new MemberArchive();
    ma.addMember(new BonusMember(1, LocalDate.now(), "Name", "Email", "Password"));

    assert ma.findPoints(1, "Password") == 0;
  }

  @Test
  @DisplayName("Only one member with a given membership number can be added")
  void onlyOneMemberWithAGivenMembershipNumberCanBeAdded() {
    MemberArchive ma = new MemberArchive();
    ma.addMember(new BonusMember(1, LocalDate.now(), "Name", "Email", "Password"));

    assert ma.addMember(new BonusMember(1, LocalDate.now(), "Name", "Email", "Password")) == -1;
  }

  @Test
  @DisplayName("Registering points increases total points")
  void registeringPointsIncreasesTotalPoints() {
    MemberArchive ma = new MemberArchive();
    ma.addMember(new BonusMember(1, LocalDate.now(), "Name", "Email", "Password"));
    ma.registerPoints(1, 1000);

    assert ma.findPoints(1, "Password") == 1000;
  }

  @Test
  @DisplayName("Points cannot be registered to non-existing user")
  void pointsCannotBeRegisteredToNonExistingUser() {
    MemberArchive ma = new MemberArchive();

    assert !ma.registerPoints(1, 1000);
  }
}
