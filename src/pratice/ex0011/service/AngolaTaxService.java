package pratice.ex0011.service;

public class AngolaTaxService {

    public double tax(double amount){
        if(amount <= 100.0){
            return amount*0.20;
        }else {
            return amount * 0.15;
        }
    }
}
