package ProgrammingWithClasses.AggregationAndComposition.Task2_Car;

import java.util.Arrays;
import java.util.List;

public class Car {
    private String carModel;
    private Engine engine;
    private Wheel[] wheels;
    private int tankVolume;
    private int fuelLevel;

    public static final int CAR_WHEELS_QUANTITY = 4;
    public static final List<Integer> ALLOWABLE_WHEEL_DIAMETER = List.of(17, 16, 15, 14);


    public Car(String carModel, Engine engine, Wheel[] wheels, int tankVolume) {
        this.carModel = carModel;
        this.setEngine(engine);
        this.setWheels(wheels);
        this.tankVolume = tankVolume;
    }

    public void go(int distance) throws IllegalArgumentException {
        if(fuelLevel / engine.getFuelConsumption() >= distance) {
            System.out.printf("The car have gone %s kilometers\n", distance);
            fuelLevel -= engine.getFuelConsumption() * distance;
        } else {
            throw new IllegalArgumentException("fuel level is not enough for given distance");
        }
    }

    public void refuel(int refuelAmount) {
        if ((fuelLevel + refuelAmount) <= tankVolume) {
            fuelLevel = fuelLevel + refuelAmount;
        } else {
            throw new IllegalArgumentException("decrease refuel amount");
        }
    }

    public void changeWheel(WheelLocation location, Wheel wheelIn) {
            if(wheelIn.getDiameter() == wheels[0].getDiameter()) {
                for(int i = 0; i < wheels.length; i++) {
                    if(wheels[i].getWheelLocation().name().equalsIgnoreCase(location.name())) {
                        wheelIn.setWheelLocation(location);
                        wheels[i] = wheelIn;
                    }
                }
            }
        }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) throws IllegalArgumentException{
        if (this.carModel.equals(engine.getCarModel())) {
            this.engine = engine;
        } else {
            throw new IllegalArgumentException("This engine does not match car specification");
        }
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) throws IllegalArgumentException {
        if (wheels.length == CAR_WHEELS_QUANTITY
                && Arrays.stream(wheels).map(Wheel::getDiameter).distinct().count() == 1
                && ALLOWABLE_WHEEL_DIAMETER.contains(wheels[0].getDiameter())
        ) {
            int index = 0;
            for(WheelLocation location : WheelLocation.values()) {
                wheels[index].setWheelLocation(location);
                index++;
            };
            this.wheels = wheels;
        } else {
            throw new IllegalArgumentException("Check wheel quantity or allowable diameter!");
        }
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    @Override
    public String toString() {
        return "Car: " +
                "carModel = " + carModel +
                ", engine = " + engine +
                ", wheels = " + Arrays.toString(wheels) +
                ", tankVolume = " + tankVolume +
                ", fuelLevel = " + fuelLevel;
    }
}
