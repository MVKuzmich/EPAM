package programming_with_classes.simple_classes.task5_counter;

public class Counter {
    private int currentValue;
    private int start;
    private int end;

    public Counter(int start, int end) {
        this.start = Math.min(start, end);
        this.end = Math.max(start, end);
        currentValue = this.start;
    }

    public Counter() {
        end = 100;
    }

    public void increaseCounter() {
        if (currentValue < end) {
            currentValue++;
        }
    }

    public void decreaseCounter() {
        if(currentValue > start) {
            currentValue--;
        }
    }
    public int getCurrentValue() {
        return currentValue;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
