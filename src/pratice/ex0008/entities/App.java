package pratice.ex0008.entities;

import pratice.ex0008.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();


        System.out.print("Enter the number of shapes: ");
        int n = scan.nextInt();
        for (int i = 1; i<(n+1); i++){
            System.out.println("Shape #"+i+" data:");

            System.out.print("Rectangle or Circle (r/c)? ");
            char choose = scan.next().charAt(0);

            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(scan.next());

            if(choose == 'r'){
                System.out.print("Width: ");
                double width = scan.nextDouble();
                System.out.print("Height: ");
                double height = scan.nextDouble();
                shapes.add(new Rectangle(color, height, width));

            }else {
                System.out.print("Radius: ");
                double radius = scan.nextDouble();
                shapes.add(new Circle(color, radius));
            }
        }
        System.out.println();
        System.out.println("SHAPE AREAS:");
        for (Shape obj: shapes){
            System.out.println(String.format("%.2f", obj.area()));
        }
    }
}
