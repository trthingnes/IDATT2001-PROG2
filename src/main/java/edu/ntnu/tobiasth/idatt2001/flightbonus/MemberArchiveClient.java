package edu.ntnu.tobiasth.idatt2001.flightbonus;

public class MemberArchiveClient {
    public static void main(String[] args) {
        MemberArchive memberArchive = new MemberArchive();
        memberArchive.addDummyData();
        memberArchive.listAllMembers();

        System.out.println("\nAdd some bonuspoints to all of the members..\n");

        System.out.println("Member 1 gets 10.000");
        memberArchive.registerPoints(1, 10000);

        System.out.println("Member 2 gets 10.000");
        memberArchive.registerPoints(2, 10000);

        System.out.println("Member 3 gets 10.000");
        memberArchive.registerPoints(3, 10000);

        System.out.println("Member 4 gets 10.000");
        memberArchive.registerPoints(4, 10000);

        System.out.println("Member 5 gets 10.000");
        memberArchive.registerPoints(5, 10000);

        System.out.println("Now lets see the register:\n");
        memberArchive.listAllMembers();
    }
}
