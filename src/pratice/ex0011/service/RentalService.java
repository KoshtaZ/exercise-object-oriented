package pratice.ex0011.service;

import pratice.ex0011.model.CarRental;
import pratice.ex0011.model.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private AngolaTaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, AngolaTaxService service) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = service;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void processInvoice(CarRental carRental){

        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayments;
        if (hours <= 12.0){
            basicPayments = pricePerHour * Math.ceil(hours);
        }else {
            basicPayments = pricePerDay * Math.ceil(hours / 24.0);
        }

        double tax = taxService.tax(basicPayments);
        carRental.setInvoice(new Invoice(basicPayments , tax));

    }
}
