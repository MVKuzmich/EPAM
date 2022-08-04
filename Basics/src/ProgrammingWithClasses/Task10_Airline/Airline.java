package ProgrammingWithClasses.Task10_Airline;

import java.time.LocalTime;

public class Airline {
    private Destination destination;
    private int flightNumber;
    private PlaneType planeType;
    LocalTime departureTime;
    private WeekDay weekDay;

    public Airline(Destination destination, int flightNumber, PlaneType planeType, LocalTime departureTime, WeekDay weekDay) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departureTime = departureTime;
        this.weekDay = weekDay;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return "Airline: destination = " + destination +
                ", flightNumber = " + flightNumber +
                ", planeType = " + planeType +
                ", departureTime = " + departureTime +
                ", weekDay = " + weekDay;
    }
}
