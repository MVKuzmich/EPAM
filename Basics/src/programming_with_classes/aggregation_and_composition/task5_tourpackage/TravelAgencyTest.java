package programming_with_classes.aggregation_and_composition.task5_tourpackage;

public class TravelAgencyTest {

    public static void main(String[] args) {
    TravelAgency agency = new TravelAgency("Star");

    Tour tour1 = new Tour(TourType.CRUISE, TransportType.SEA, HasFood.YES, 10, agency);
    Tour tour2 = new Tour(TourType.EXCURSION, TransportType.AUTO, HasFood.NO, 7, agency);
    Tour tour3 = new Tour(TourType.RECREATION, TransportType.AIR, HasFood.YES, 14, agency);
    Tour tour4 = new Tour(TourType.SHOPPING, TransportType.AUTO, HasFood.NO, 3, agency);
    Tour tour5 = new Tour(TourType.TREATMENT, TransportType.RAILWAY, HasFood.YES, 14, agency);
    Tour tour6 = new Tour(TourType.TREATMENT, TransportType.AIR, HasFood.NO, 14, agency);
    Tour tour7 = new Tour(TourType.CRUISE, TransportType.SEA, HasFood.YES, 5, agency);
    Tour tour8 = new Tour(TourType.EXCURSION, TransportType.AUTO, HasFood.YES, 3, agency);
    Tour tour9 = new Tour(TourType.RECREATION, TransportType.RAILWAY, HasFood.YES, 5, agency);
    Tour tour10 = new Tour(TourType.SHOPPING, TransportType.AUTO, HasFood.NO, 1, agency);


        System.out.printf("Find tours by TOUR TYPE: %s\n", agency.findTourByCriteria(TourType.CRUISE));
        System.out.printf("Find tours by TRANSPORT TYPE: %s\n", agency.findTourByCriteria(TransportType.AIR));
        System.out.printf("Find tours by FOOD AVAILABILITY: %s\n", agency.findTourByCriteria(HasFood.YES));
        System.out.printf("Find tours by DAY COUNT: %s\n", agency.findTourByCriteria(5));
        System.out.printf("Find tours by TOUR TYPE, TRANSPORT TYPE: %s\n", agency.findTourByCriteria(TourType.RECREATION, TransportType.AIR));
        System.out.printf("Find tours by TOUR TYPE, TRANSPORT TYPE, FOOD AVAILABILITY: %s\n", agency.findTourByCriteria(TourType.RECREATION, TransportType.AIR, HasFood.YES));

        agency.sortTourByTourType();
        System.out.printf("Sorted tour by TOUR TYPE: %s\n", agency.getTours());
        agency.sortTourByTransportType();
        System.out.printf("Sorted tour by TRANSPORT TYPE: %s\n", agency.getTours());
        agency.sortTourByHasFood();
        System.out.printf("Sorted tour by FOOD AVAILABILITY: %s\n", agency.getTours());
        agency.sortTourByDayCount();
        System.out.printf("Sorted tour by DAY COUNT: %s\n", agency.getTours());



    }
}
