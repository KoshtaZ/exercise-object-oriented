package pratice.ex0010.application;

import pratice.ex0010.entities.Person;
import pratice.ex0010.entities.PessoaFisica;
import pratice.ex0010.entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = scan.nextInt();

        for(int k = 1; k<(n+1); k++){
            System.out.println("Tax payer #"+k+" data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = scan.next().charAt(0);
            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Anual income: ");
            double rendaAnual = scan.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double gastoSaude = scan.nextDouble();
                personList.add(new PessoaFisica(name, rendaAnual, gastoSaude));
            }else {
                System.out.print("Number of employees: ");
                int numeroFuncionario = scan.nextInt();
                personList.add(new PessoaJuridica(name, rendaAnual, numeroFuncionario));
            }
        }

        System.out.println();
        System.out.println("TAX PAID:");
        for (Person obj: personList){
            System.out.println(obj.getNome()+": $ " + String.format("%.2f", obj.imposto()));
        }
        double sum = 0.0;
        for (Person obj: personList){
            sum = sum + obj.imposto();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

    }
}
