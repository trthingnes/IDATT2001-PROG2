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

    /**
     * Creates a new bonus member.
     * @param memberNumber Membership number associated with member.
     * @param enrolledDate Enrollment date for member (usually DateTime.now()).
     * @param name Full member name.
     * @param emailAddress Member email address.
     * @param password Member password.
     * @author trthingnes
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, String name, String emailAddress, String password) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;

        checkAndSetMembership();
    }

    /**
     * Checks the given password against the member password.
     * @param password Password to check against records.
     * @return True if password correct, false if not.
     * @author trthingnes
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Checks if bonus point balance is high enough to upgrade membership.
     * If it is, the membership status is changed accordingly.
     * @author trthingnes
     */
    private void checkAndSetMembership() {
        if (bonusPointsBalance >= GOLD_LIMIT && !(membership instanceof GoldMembership)) {
            membership = new GoldMembership();
        } else if (bonusPointsBalance >= SILVER_LIMIT && !(membership instanceof SilverMembership)) {
            membership = new SilverMembership();
        } else if (!(membership instanceof BasicMembership)) {
            membership = new BasicMembership();
        }
    }

    /**
     * Registers new bonus points for the member.
     * @param newPoints Number of new points.
     * @author trthingnes
     */
    public void registerBonusPoints(int newPoints) {
        bonusPointsBalance = membership.registerPoints(bonusPointsBalance, newPoints);
        checkAndSetMembership();
    }

    /**
     * Gets the current membership level of the member.
     * @return Membership level string.
     * @author trthingnes
     */
    public String getMembershipLevel() {
        return membership.getMembershipName();
    }

    /**
     * Gets the member number of the member.
     * @return Membership number.
     * @author trthingnes
     */
    public int getMemberNumber() {
        return memberNumber;
    }

    /**
     * Gets the enrollment date of the member.
     * @return Enrollment date.
     * @author trthingnes
     */
    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    /**
     * Gets the bonus point balance of the member.
     * @return Bonus point balance.
     * @author trthingnes
     */
    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    /**
     * Gets the name of the member.
     * @return Name.
     * @author trthingnes
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the email address of the member.
     * @return Email address.
     * @author trthingnes
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Gets the membership object of the member.
     * @return Membership object.
     * @author trthingnes
     */
    public Membership getMembership() {
        return membership;
    }

    /**
     * Gets member summary string.
     * @return Member summary string.
     * @author trthingnes
     */
    @Override
    public String toString() {
        return String.format("%s<%s> (#%s): Enrolled: %s, Member status: %s, Point balance: %s",
                name, emailAddress, memberNumber, enrolledDate.toString(), getMembershipLevel(), getBonusPointsBalance());
    }
}
