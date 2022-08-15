package ProgrammingWithClasses.AggregationAndComposition.Task2_Car;

public class CarTest {

    public static void main(String[] args) {
        Car car = null;
        try {
            Engine engine = new Engine(200, 0.1, "Audi");
            Wheel[] wheels = {
                    new Wheel(15, "A"),
                    new Wheel(15, "A"),
                    new Wheel(15, "A"),
                    new Wheel(15, "A")
            };
            car = new Car("Audi", engine, wheels, 100);
            System.out.printf("Car model is %s\n", car.getCarModel());
            car.refuel(90);
            System.out.println(car);

            car.go(50);
            System.out.println(car);
            car.go(1000);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        Wheel wheelIn = new Wheel(15, "B");
        if (car != null) {
            car.changeWheel(WheelLocation.FRONT_LEFT, wheelIn);
            System.out.println(car);
        }
    }

}
