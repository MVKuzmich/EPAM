package ProgrammingWithClasses.Task3_Student;

public class StudentTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Ivanov M.V.", 1, new int[]{6, 7, 8, 9, 10}),
                new Student("Petrov M.O.", 1, new int[]{9, 9, 9, 9, 10}),
                new Student("Baranov A.A", 1, new int[]{8, 9, 9, 9, 10}),
                new Student("Sidorov V.L.", 2, new int[]{9, 9, 9, 9, 9}),
                new Student("Abramov M.V.", 2, new int[]{6, 7, 8, 9, 8}),
                new Student("Antonov M.K.", 2, new int[]{8, 7, 8, 8, 10}),
                new Student("Vecher O.A.", 3, new int[]{9, 10, 10, 10, 10}),
                new Student("Bedunov M.V.", 3, new int[]{6, 7, 7, 9, 10}),
                new Student("Ivanova M.M.", 4, new int[]{6, 7, 8, 9, 10}),
                new Student("Ivolgina M.V.", 4, new int[]{10, 9, 9, 9, 10}),
        };

        new Student().getBestStudents(students);
    }
}
