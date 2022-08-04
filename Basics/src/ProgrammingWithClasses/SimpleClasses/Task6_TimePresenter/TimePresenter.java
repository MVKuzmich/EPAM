package ProgrammingWithClasses.SimpleClasses.Task6_TimePresenter;

public class TimePresenter {
    private int hours;
    private int minutes;
    private int seconds;

    private static final int HOURS_LIMIT = 24;
    private static final int MINUTES_LIMIT = 60;
    private static final int SECONDS_LIMIT = 60;


    public TimePresenter(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public TimePresenter() {
    }

    public void setHours(int hours) {
        this.hours = (hours < HOURS_LIMIT) ? hours : 0;
    }

    public void setMinutes(int minutes) {
        this.minutes = (minutes < MINUTES_LIMIT) ? minutes : 0;
    }

    public void setSeconds(int seconds) {
        this.seconds = (seconds < SECONDS_LIMIT) ? seconds : 0;
    }

    public void increaseTime(int hours, int minutes, int seconds) {
        this.hours = (this.hours + hours < HOURS_LIMIT) ? (this.hours + hours) : 0;
        this.minutes = (this.minutes + minutes < MINUTES_LIMIT) ? (this.minutes + minutes) : 0;
        this.seconds = (this.seconds + seconds < SECONDS_LIMIT) ? (this.seconds + seconds) : 0;
    }
    public void decreaseTime(int hours, int minutes, int seconds) {
        this.hours = Math.max(this.hours - hours, 0);
        this.minutes = Math.max((this.minutes - minutes), 0);
        this.seconds = Math.max(this.seconds - seconds, 0);
    }

    @Override
    public String toString() {
        return "TimePresenter: hours = " + hours +
                ", minutes = " + minutes +
                ", seconds = " + seconds;
    }
}
