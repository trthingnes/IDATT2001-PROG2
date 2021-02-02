package edu.ntnu.tobiasth.idatt2001.flightbonus;

public abstract class Membership {
    public abstract int registerPoints(int bonusPointBalance, int newPoints);

    public abstract String getMembershipName();
}
