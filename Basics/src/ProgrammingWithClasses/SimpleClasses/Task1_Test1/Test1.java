package ProgrammingWithClasses.SimpleClasses.Task1_Test1;

public class Test1 {
    private int first;
    private int second;

    public void printVariables() {
        System.out.printf("First variable - %d, second variable - %d", first, second);
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSum() {
        return first + second;
    }

    public int getMax() {
        return Math.max(first, second);
    }
}
