package ProgrammingWithClasses.Task4_Train;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class Train {
    private String destinationPoint;
    private int trainNumber;
    private LocalDateTime departureTime;

    public Train(String destinationPoint, int trainNumber, LocalDateTime departureTime) {
        this.destinationPoint = destinationPoint;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public Train() {
    }

    public void sortTrainsByNumber(Train[] trains) {
        Arrays.sort(trains, Comparator.comparing(Train::getTrainNumber));
    }

    public Train getInformationAboutTrain(Train[] trains, int trainNumber) {
        return Arrays.stream(trains).filter(train -> train.getTrainNumber() == trainNumber).findFirst().orElseThrow(() -> new RuntimeException("Such train does not exist"));
    }

    public void sortTrainsByDestinationPoint(Train[] trains) {
        Arrays.sort(trains, Comparator.comparing(Train::getDestinationPoint).thenComparing(Train::getDepartureTime));
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "\nTrain: destinationPoint = " + destinationPoint +
                ", trainNumber = " + trainNumber +
                ", departureTime = " + departureTime;
    }
}
