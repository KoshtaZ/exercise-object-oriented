package pratice.ex0011.app;

import pratice.ex0011.model.CarRental;
import pratice.ex0011.model.Vehicle;
import pratice.ex0011.service.AngolaTaxService;
import pratice.ex0011.service.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental date ");
        System.out.print("Car model: ");
        String carModel = scan.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        LocalDateTime  start = LocalDateTime.parse(scan.nextLine(), fmt);
        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(scan.nextLine(), fmt);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        double pricePerHour = scan.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = scan.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new AngolaTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("INVOICE");
        System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().totalPayment()));
    }
}
