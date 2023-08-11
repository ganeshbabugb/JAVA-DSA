package datastructures.zoho.railway;

import java.util.ArrayList;

public class Service {
    public static void printTickets(ArrayList<People> people, String title) {
        System.out.println(title.toUpperCase());
        if (people.size() == 0) {
            System.out.println("NO TICKET WAS BOOKED");
            return;
        }
        for (People aPerson : people) {
            System.out.println("*".repeat(20));
            System.out.println("Name = " + aPerson.getName());
            System.out.println("Age = " + aPerson.getAge());
            System.out.println("Gender = " + aPerson.getGender());
            System.out.println("BerthPreference = " + aPerson.getBerthPreference());
        }
    }
}
