import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    String weather;
    double budget;

    Destination(String name, String date, String weather, double budget) {
        this.name = name;
        this.date = date;
        this.weather = weather;
        this.budget = budget;
    }

    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Weather: " + weather + ", Budget: $" + budget;
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();
        char addMore;

        do {
            System.out.print("Enter destination: ");
            String destinationName = scanner.nextLine();

            System.out.print("Enter travel date (dd-mm-yyyy): ");
            String travelDate = scanner.nextLine();

            System.out.print("Enter expected weather: ");
            String weatherInfo = scanner.nextLine();

            System.out.print("Enter budget for this destination: ");
            double budget = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            Destination destination = new Destination(destinationName, travelDate, weatherInfo, budget);
            itinerary.add(destination);

            System.out.print("Do you want to add another destination? (y/n): ");
            addMore = scanner.next().charAt(0);
            scanner.nextLine(); // consume newline

        } while (addMore == 'y' || addMore == 'Y');

        // Display itinerary
        System.out.println("\n--- Your Travel Itinerary ---");
        double totalBudget = 0;
        for (Destination d : itinerary) {
            System.out.println(d);
            totalBudget += d.budget;
        }
        System.out.println("Total Estimated Budget: $" + totalBudget);

        scanner.close();
    }
}