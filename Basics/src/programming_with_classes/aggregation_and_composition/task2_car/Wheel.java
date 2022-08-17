package programming_with_classes.aggregation_and_composition.task2_car;

public class Wheel {
    private int diameter;
    private WheelLocation location;
    private String brand;

    public Wheel(int diameter, String brand) {
        this.diameter = diameter;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public WheelLocation getWheelLocation() {
        return location;
    }

    public void setWheelLocation(WheelLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Wheel: diameter = " + diameter +
                ", carLocation = " + location.name().toLowerCase() +
                ", brand = " + brand;
    }
}
