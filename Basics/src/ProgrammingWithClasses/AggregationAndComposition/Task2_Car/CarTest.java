package ProgrammingWithClasses.AggregationAndComposition.Task2_Car;

public class CarTest {

    public static void main(String[] args) {

        Engine engine = new Engine(200, 0.1, "Audi");
        Wheel[] wheels = {
                new Wheel(15, "A"),
                new Wheel(15, "A"),
                new Wheel(15, "A"),
                new Wheel(15, "A")
        };
        Car car = new Car("Audi", engine, wheels, 100);

        car.refuel(90);
        System.out.println(car);

        car.go(50);
        System.out.println(car);

        Wheel wheelIn = new Wheel(15, "B");
        car.changeWheel(WheelLocation.FRONT_LEFT, wheelIn);
        System.out.println(car);
    }


}
