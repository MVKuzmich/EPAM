package programming_with_classes.simple_classes.task4_train;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TrainTest {
    public static void main(String[] args) {
        Train trainTest = new Train();
        Train[] trains = {
                new Train("Moscow", 123, LocalDateTime.of(2022, 8,1, 12, 20)),
                new Train("Warsaw", 100, LocalDateTime.of(2022, 8,15, 6, 20)),
                new Train("Rome", 105, LocalDateTime.of(2022, 8,14, 8, 20)),
                new Train("Rome", 102, LocalDateTime.of(2022, 8,11, 11, 20)),
                new Train("Rostov", 140, LocalDateTime.of(2022, 8,2, 10, 20)),
        };

        trainTest.sortTrainsByDestinationPoint(trains);
        System.out.println(Arrays.toString(trains));

        trainTest.sortTrainsByNumber(trains);
        System.out.println(Arrays.toString(trains));

        System.out.println(trainTest.getInformationAboutTrain(trains, 100));



    }
}
