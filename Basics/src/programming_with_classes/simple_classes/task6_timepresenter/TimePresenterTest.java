package programming_with_classes.simple_classes.task6_timepresenter;

public class TimePresenterTest {

    public static void main(String[] args) {
        TimePresenter timePresenter = new TimePresenter();
        timePresenter.setHours(25);
        timePresenter.setMinutes(61);
        timePresenter.setSeconds(33);

        System.out.println(timePresenter);

        timePresenter.increaseTime(20, 24, 20);
        System.out.println(timePresenter);

        timePresenter.decreaseTime(23, 20 , 20);
        System.out.println(timePresenter);
    }
}
