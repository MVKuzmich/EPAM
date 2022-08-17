package programming_with_classes.simple_classes.task5_counter;

public class CounterTest {

    public static void main(String[] args) {

        Counter counter1 = new Counter(20, 3);
        Counter counter2 = new Counter(5, 50);
        Counter counter = new Counter();
        //увеличиваем на 70 единиц
        for (int i = 1; i <= 70; i++) {
            counter.increaseCounter();
            counter1.increaseCounter();
            counter2.increaseCounter();
        }
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter1.getCurrentValue(), counter1.getStart(), counter1.getEnd());
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter2.getCurrentValue(), counter2.getStart(), counter2.getEnd());
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter.getCurrentValue(), counter.getStart(), counter.getEnd());

        //уменьшаем текущее значение на 14 единиц
        for (int i = 1; i <= 14; i++) {
            counter.decreaseCounter();
            counter1.decreaseCounter();
            counter2.decreaseCounter();
        }
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter1.getCurrentValue(), counter1.getStart(), counter1.getEnd());
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter2.getCurrentValue(), counter2.getStart(), counter2.getEnd());
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter.getCurrentValue(), counter.getStart(), counter.getEnd());

        //уменьшаем на 70 единиц
        for (int i = 1; i <= 70; i++) {
            counter.decreaseCounter();
            counter1.decreaseCounter();
            counter2.decreaseCounter();
        }
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter1.getCurrentValue(), counter1.getStart(), counter1.getEnd());
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter2.getCurrentValue(), counter2.getStart(), counter2.getEnd());
        System.out.printf("counter: current value: %d, start: %d, end: %d\n", counter.getCurrentValue(), counter.getStart(), counter.getEnd());
    }
}
