package edu.ntnu.tobiasth.idatt2001.flightbonus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@DisplayName("Membership tests")
public class MembershipTest {
    @Test
    @DisplayName("Basic members get correct point scaling factor")
    void basicMembersGetCorrectScalingFactor() {
        BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");
        bm.registerBonusPoints(1000);

        assert bm.getBonusPointsBalance() == 1000;
    }

    @Test
    @DisplayName("Silver members get correct point scaling factor")
    void silverMembersGetCorrectScalingFactor() {
        BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");
        bm.registerBonusPoints(25000);
        bm.registerBonusPoints(1000);

        assert bm.getBonusPointsBalance() == 25000 + 1200;
    }

    @Test
    @DisplayName("Gold members get correct point scaling factor with less than 90000 points")
    void goldMembersGetCorrectScalingFactorWithLessThan90000() {
        BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");
        bm.registerBonusPoints(75000);
        bm.registerBonusPoints(1000);

        assert bm.getBonusPointsBalance() == 75000 + 1300;
    }

    @Test
    @DisplayName("Gold members get correct point scaling factor with more than 90000 points")
    void goldMembersGetCorrectScalingFactorWithMoreThan90000() {
        BonusMember bm = new BonusMember(1, LocalDate.now(), "Name", "Email", "Password");
        bm.registerBonusPoints(90000);
        bm.registerBonusPoints(1000);

        assert bm.getBonusPointsBalance() == 90000 + 1500;
    }
}
