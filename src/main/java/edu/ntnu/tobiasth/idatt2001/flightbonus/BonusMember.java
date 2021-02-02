package edu.ntnu.tobiasth.idatt2001.flightbonus;

import java.time.LocalDate;

public class BonusMember {
    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    private final int memberNumber;
    private final LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String emailAddress;
    private String password;
    private Membership membership;

    public BonusMember(int memberNumber, LocalDate enrolledDate, String name, String emailAddress, String password) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;

        checkAndSetMembership();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    private void checkAndSetMembership() {
        if (bonusPointsBalance >= GOLD_LIMIT && !(membership instanceof GoldMembership)) {
            membership = new GoldMembership();
        } else if (bonusPointsBalance >= SILVER_LIMIT && !(membership instanceof SilverMembership)) {
            membership = new SilverMembership();
        } else if (!(membership instanceof BasicMembership)) {
            membership = new BasicMembership();
        }
    }

    public void registerBonusPoints(int newPoints) {
        bonusPointsBalance = membership.registerPoints(bonusPointsBalance, newPoints);
        checkAndSetMembership();
    }

    public String getMembershipLevel() {
        return membership.getMembershipName();
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Membership getMembership() {
        return membership;
    }

    @Override
    public String toString() {
        return String.format("%s<%s> (#%s): Enrolled: %s, Member status: %s, Point balance: %s",
                name, emailAddress, memberNumber, enrolledDate.toString(), getMembershipLevel(), getBonusPointsBalance());
    }
}
