package programming_with_classes.aggregation_and_composition.task5_tourpackage;

public class Tour {
    private TourType tourType;
    private TransportType transportType;
    private HasFood hasFood;
    private int tourDayCount;
    private TravelAgency agency;

    public Tour(TourType tourType, TransportType transportType, HasFood hasFood, int tourDayCount, TravelAgency agency) {
        this.tourType = tourType;
        this.transportType = transportType;
        this.hasFood = hasFood;
        this.tourDayCount = tourDayCount;
        this.agency = agency;
        this.agency.getTours().add(this);
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public HasFood getHasFood() {
        return hasFood;
    }

    public void setHasFood(HasFood hasFood) {
        this.hasFood = hasFood;
    }

    public int getTourDayCount() {
        return tourDayCount;
    }

    public void setTourDayCount(int tourDayCount) {
        this.tourDayCount = tourDayCount;
    }

    public TravelAgency getAgency() {
        return agency;
    }

    public void setAgency(TravelAgency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "Tour: " +
                "tourType = " + tourType.name() +
                ", transportType = " + transportType.name() +
                ", hasFood = " + hasFood.name() +
                ", tourDayCount = " + tourDayCount;
    }
}
