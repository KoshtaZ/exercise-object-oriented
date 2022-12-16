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

        System.out.println("Entre com os dados do aluguel ");
        System.out.print("Modelo do carro: ");
        String carModel = scan.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime  start = LocalDateTime.parse(scan.nextLine(), fmt);
        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(scan.nextLine(), fmt);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = scan.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = scan.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new AngolaTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("FATURA");
        System.out.println("Pagamento basico: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f", carRental.getInvoice().totalPayment()));
    }
}
