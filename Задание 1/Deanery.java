import java.util.Set;

public class Deanery {
    public static void deleteStudent(Set<Student> students){
        students.removeIf(student -> student.getAverage() < 3);
        
    }

    public static void printStudents(Set<Student> students, int course){
        int count = 0;
        for (Student o : students) {
            if (o.getCourse() == course) {
                System.out.println(o.getName() + " курс: " + o.getCourse());
                count++;
            } 
        }
        if (count == 0) {
            System.out.println("Курс пуст");
        }
    }

    public static void studentTransfer(Set<Student> students){
        for (Student o : students) {
            o.courseUp();
        }
    }
}
