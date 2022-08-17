package programming_with_classes.simple_classes.task10_airline;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {

    List<Airline> airlineList = new ArrayList<>();

    public void addAirline(Airline airline) {
        airlineList.add(airline);
    }

    public List<Airline> findAirlineByDestination(String destination) {
        return airlineList.stream()
                .filter(airline -> airline.getDestination().name().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }

    public List<Airline> findAirlineByWeekDay(String weekDay) {
        return airlineList.stream()
                .filter(airline -> airline.getWeekDay().name().equalsIgnoreCase(weekDay))
                .collect(Collectors.toList());
    }

    public List<Airline> findAirlineByWeekDayAndDepartureTimeGreaterThan(String weekDay, String departureTime) {
        LocalTime time = LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm"));
        return airlineList.stream()
                .filter(airline -> airline.getWeekDay().name().equalsIgnoreCase(weekDay) && airline.getDepartureTime().isAfter(time))
                .collect(Collectors.toList());
    }
}
