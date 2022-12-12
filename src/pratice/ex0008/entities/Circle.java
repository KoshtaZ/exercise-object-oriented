package pratice.ex0008.entities;

import pratice.ex0008.entities.enums.Color;

public class Circle extends Shape{
    private Double rauis;

    public Circle(){
        super();
    }

    public Circle(Color color, Double rauis) {
        super(color);
        this.rauis = rauis;
    }

    public Double getRauis() {
        return rauis;
    }

    public void setRauis(Double rauis) {
        this.rauis = rauis;
    }

    @Override
    public double area() {
        return Math.PI*rauis*rauis;
    }
}
