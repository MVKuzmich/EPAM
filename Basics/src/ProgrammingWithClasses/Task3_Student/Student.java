package ProgrammingWithClasses.Task3_Student;

public class Student {
    private String fullName;
    private int groupNumber;
    private int[] progress;

    public Student(String fullName, int groupNumber, int[] progress) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.progress = progress;
    }

    public Student() {
    }

    public void getBestStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            int countBestMarks = 0;
            int[] progress = students[i].getProgress();
            for (int j = 0; j < progress.length; j++) {
                if (progress[j] >= 9) {
                    countBestMarks++;
                }
            }
            if (countBestMarks == 5) {
                System.out.printf("Студент %s, группа %d \n", students[i].getFullName(), students[i].getGroupNumber());
            }
        }
    }

    public String getFullName() {
        return fullName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public int[] getProgress() {
        return progress;
    }
}
