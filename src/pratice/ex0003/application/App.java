package pratice.ex0003.application;

import pratice.ex0003.entities.Client;
import pratice.ex0003.entities.Order;
import pratice.ex0003.entities.OrderItem;
import pratice.ex0003.entities.Product;
import pratice.ex0003.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String clientName = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(scan.next());

        Client client = new Client(clientName, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scan.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int n = scan.nextInt();
        for (int i = 1; i<(n+1) ; i++){
            System.out.println("Enter #"+i+" item data: ");
            System.out.print("Product name: ");
            scan.nextLine();
            String productName = scan.nextLine();
            System.out.print("Product price: ");
            double productPrice = scan.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantity = scan.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addOrderItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
        scan.close();
    }
}
