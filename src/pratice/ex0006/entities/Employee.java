package pratice.ex0006.entities;

public class Employee {
    private String name;
    private Integer hours;
    private Double valurPerHour;

    public Employee(){

    }

    public Employee(String name, Integer hours, Double valurPerHour) {
        this.name = name;
        this.hours = hours;
        this.valurPerHour = valurPerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getValurPerHour() {
        return valurPerHour;
    }

    public void setValurPerHour(Double valurPerHour) {
        this.valurPerHour = valurPerHour;
    }

    public double payment(){
        return valurPerHour*hours;
    }

    public String toString(){
        return name + " - $ " + String.format("%.2f", payment());
    }
}
