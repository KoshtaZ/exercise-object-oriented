package pratice.ex0006.application;

import pratice.ex0006.entities.Employee;
import pratice.ex0006.entities.OutSourceEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();
        Employee[] employee = new Employee[3];

        System.out.print("Enter the number of employees: ");
        int n = scan.nextInt();

        for (int i = 1; i<(n+1); i++){

            System.out.println("Employee #"+i+ " data:");
            System.out.print("Outsourced (y/n)? ");
            char choose = scan.next().charAt(0);
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Hours: ");
            int hours = scan.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHours = scan.nextDouble();;

            if (choose == 'y' || choose == 'Y'){
                System.out.print("Additional charge: ");
                double additionalCharge = scan.nextDouble();
                employees.add(new OutSourceEmployee(name, hours, valuePerHours, additionalCharge));
            }
            else if(choose == 'n' || choose == 'N') {
                employees.add(new Employee(name, hours, valuePerHours));
            }else {
                System.out.println("OPÇÃO INVÁLIDA! ENCERRANDO O PROGRAMA...");
            }

        }
        System.out.println();
        System.out.println("PAYMENTS");
        for (Employee obj: employees){
            System.out.println(obj);
        }
    }
}
