package programming_with_classes.simple_classes.task10_airline;

import java.time.LocalTime;

public class AirportTest {
    public static void main(String[] args) {
        Airport airport = new Airport();
        airport.addAirline(new Airline(Destination.BERLIN, 1050, PlaneType.AIRBUS, LocalTime.of(12, 15), WeekDay.FRIDAY));
        airport.addAirline(new Airline(Destination.LONDON, 1060, PlaneType.BOEING, LocalTime.of(1, 15), WeekDay.MONDAY));
        airport.addAirline(new Airline(Destination.MOSCOW, 1070, PlaneType.EMBRAER, LocalTime.of(10, 15), WeekDay.FRIDAY));
        airport.addAirline(new Airline(Destination.PARIS, 1080, PlaneType.AIRBUS, LocalTime.of(13, 15), WeekDay.SATURDAY));
        airport.addAirline(new Airline(Destination.WARSAW, 1090, PlaneType.BOEING, LocalTime.of(12, 50), WeekDay.THURSDAY));
        airport.addAirline(new Airline(Destination.WARSAW, 1011, PlaneType.EMBRAER, LocalTime.of(12, 30), WeekDay.FRIDAY));
        airport.addAirline(new Airline(Destination.BERLIN, 1021, PlaneType.BOEING, LocalTime.of(11, 15), WeekDay.SUNDAY));
        airport.addAirline(new Airline(Destination.PARIS, 1031, PlaneType.AIRBUS, LocalTime.of(9, 15), WeekDay.THURSDAY));
        airport.addAirline(new Airline(Destination.MOSCOW, 1041, PlaneType.EMBRAER, LocalTime.of(12, 15), WeekDay.TUESDAY));
        airport.addAirline(new Airline(Destination.MOSCOW, 1051, PlaneType.AIRBUS, LocalTime.of(23, 15), WeekDay.WEDNESDAY));
        airport.addAirline(new Airline(Destination.BERLIN, 1061, PlaneType.BOEING, LocalTime.of(20, 15), WeekDay.FRIDAY));

        System.out.println("airline list by destination: ");
        airport.findAirlineByDestination("moscow").forEach(System.out::println);
        System.out.println("airline list by week day: ");
        airport.findAirlineByWeekDay("Monday").forEach(System.out::println);
        System.out.println("airline list by week day and departure time is greater than: ");
        airport.findAirlineByWeekDayAndDepartureTimeGreaterThan("friday", "12:00").forEach(System.out::println);


    }

}
