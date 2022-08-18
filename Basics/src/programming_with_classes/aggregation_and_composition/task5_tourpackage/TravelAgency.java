package programming_with_classes.aggregation_and_composition.task5_tourpackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TravelAgency {
    private String name;
    List<Client> clients;
    List<Tour> tours;

    public TravelAgency(String name) {
        this.name = name;
        clients = new ArrayList<>();
        tours = new ArrayList<>();
    }

    public List<Tour> findTourByCriteria(TourType tourType) {
        return tours.stream()
                .filter(tour -> tour.getTourType().equals(tourType))
                .collect(Collectors.toList());
    }

    public List<Tour> findTourByCriteria(TransportType transportType) {
        return tours.stream()
                .filter(tour -> tour.getTransportType().equals(transportType))
                .collect(Collectors.toList());
    }

    public List<Tour> findTourByCriteria(HasFood hasFood) {
        return tours.stream()
                .filter(tour -> tour.getHasFood().equals(hasFood))
                .collect(Collectors.toList());
    }

    public List<Tour> findTourByCriteria(int dayCount) {
        return tours.stream()
                .filter(tour -> tour.getTourDayCount() >= dayCount)
                .collect(Collectors.toList());
    }

    public List<Tour> findTourByCriteria(TourType tourType, TransportType transportType) {
        return findTourByCriteria(tourType).stream()
                .filter(tour -> tour.getTransportType().equals(transportType))
                .collect(Collectors.toList());
    }

    public List<Tour> findTourByCriteria(TourType tourType, TransportType transportType, HasFood hasFood) {
        return findTourByCriteria(tourType, transportType).stream()
                .filter(tour -> tour.getHasFood().equals(hasFood))
                .collect(Collectors.toList());
    }

    public List<Tour> findTourByCriteria(TourType tourType, TransportType transportType, HasFood hasFood, int dayCount) {
        return findTourByCriteria(tourType, transportType, hasFood).stream()
                .filter(tour -> tour.getTourDayCount() >= dayCount)
                .collect(Collectors.toList());
    }

    public void sortTourByTourType() {
        tours.sort(Comparator.comparing(tour -> tour.getTourType().name()));
    }
    public void sortTourByTransportType() {
        tours.sort(Comparator.comparing(tour -> tour.getTransportType().name()));
    }
    public void sortTourByHasFood() {
        tours.sort(Comparator.comparing(tour -> tour.getHasFood().name()));
    }
    public void sortTourByDayCount() {
        tours.sort(Comparator.comparing(Tour::getTourDayCount));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
}
