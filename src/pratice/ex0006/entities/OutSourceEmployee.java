package pratice.ex0006.entities;

public class OutSourceEmployee extends Employee{
    private Double additionalCharge;

    public OutSourceEmployee(){
        super();
    }

    public OutSourceEmployee(String name, Integer hours, Double valurPerHour, Double additionalCharge) {
        super(name, hours, valurPerHour);
        this.additionalCharge = additionalCharge;
    }

    public Double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double payment(){
        return super.payment() + (110*additionalCharge)/100;
    }
}
