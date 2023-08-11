package datastructures.zoho.railway;

import java.util.ArrayList;
import java.util.Scanner;

/*
*
*
* */


public class Main {
    static final int TOTAL_BERTHS_TICKET = 63;
    static final int TOTAL_RAC_TICKET = 18;
    static final int TOTAL_WAITING_LIST_TICKET = 10;

    static ArrayList<People> confirmedTicket = new ArrayList<>();
    static ArrayList<People> racTicket = new ArrayList<>();
    static ArrayList<People> waitingListTicket = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("RAILWAY RESERVATION SYSTEM");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. Booking
                    2. Cancel
                    3. Print Booked Tickets
                    4. Print Available Ticket
                    5. Exit""");

            System.out.print("Enter Your Choice : ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1 -> bookTicket(scanner);
                case 2 -> cancelTicket(scanner);
                case 3 -> printBookedTicket(confirmedTicket);
                case 4 -> printAvailableTicket();
                case 5 -> {
                    System.out.println("Program Exited");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("INVALID INPUT");
            }
        }
    }

    private static void printBookedTicket(ArrayList<People> passenger) {
        Service.printTickets(passenger, "BOOKED TICKETS");
    }

    private static void printAvailableTicket() {
        System.out.print("Available Tickets");
        System.out.printf("Confirmed Ticket : %d%nRAC Ticket : %d%nWaiting List Ticket : %d%n",
                TOTAL_BERTHS_TICKET - confirmedTicket.size(),
                TOTAL_RAC_TICKET - racTicket.size(),
                TOTAL_WAITING_LIST_TICKET - waitingListTicket.size());
    }

    private static void bookTicket(Scanner scanner) {
        if (waitingListTicket.size() > TOTAL_WAITING_LIST_TICKET) {
            System.out.print("NO TICKETS AVAILABLE");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter passenger age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter passenger gender (M/F): ");
        char gender = scanner.nextLine().charAt(0);

        System.out.print("Enter berth preference (U/L/S): ");
        char berthPreference = scanner.nextLine().charAt(0);

        People person = new People(name, age, gender, berthPreference);

        if (person.getAge() < 5) {
            System.out.println("There Is No Ticket for Child");
            waitingListTicket.add(person);
        } else if (person.getAge() >= 60 || person.getGender() == 'F' && person.getAge() > 5) {
            allocateBerth(confirmedTicket, person);
        } else {
            allocateBerth(racTicket, person);
        }
    }

    private static void allocateBerth(ArrayList<People> ticket, People passenger) {
        if (ticket.size() < TOTAL_BERTHS_TICKET) {
            confirmedTicket.add(passenger);
            System.out.println("Ticket Booked Successful");
        } else {
            if (racTicket.size() < TOTAL_RAC_TICKET) {
                racTicket.add(passenger);
                System.out.println("The ticket was booked under RAC");
            } else if (waitingListTicket.size() < TOTAL_WAITING_LIST_TICKET) {
                waitingListTicket.add(passenger);
                System.out.println("The ticket was booked under Waiting List");
            } else {
                System.out.println("No Ticket Available");
            }
        }
    }

    private static void cancelTicket(Scanner scanner) {
        System.out.print("Enter your passengerName to cancel the ticket : ");
        String passengerName = scanner.nextLine();

        boolean removed = false;

        for (int i = 0; i < confirmedTicket.size(); i++) {
            if (confirmedTicket.get(i).getName().equalsIgnoreCase(passengerName)) {
                confirmedTicket.remove(i);
                removed = true;
                System.out.printf("The Ticket for %s has been canceled%n", passengerName);
                break;
            }
        }

        if (!removed) {
            System.out.printf("The Ticket for %s was not found in booked ticket%n", passengerName);
        }
    }
}