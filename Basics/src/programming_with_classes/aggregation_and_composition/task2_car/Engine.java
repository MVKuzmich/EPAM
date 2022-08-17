package programming_with_classes.aggregation_and_composition.task2_car;

public class Engine {
    private int power;
    private double fuelConsumption;
    private String carModel;

    public Engine(int power, double fuelConsumption, String carModel) {
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.carModel = carModel;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "Engine: power = " + power +
                ", fuelConsumption = " + fuelConsumption;
    }
}
