import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {

        // 1. CGPA in decreasing order
        if (a.cgpa != b.cgpa) {
            return Double.compare(b.cgpa, a.cgpa);
        }

        // 2. Name in alphabetical order
        if (!a.name.equals(b.name)) {
            return a.name.compareTo(b.name);
        }

        // 3. ID in increasing order
        return Integer.compare(a.id, b.id);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, new StudentComparator());

        for (Student student : students) {
            System.out.println(student.name);
        }

        sc.close();
    }
}