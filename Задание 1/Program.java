import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {
        Set<Student> students = new LinkedHashSet<>();

        TreeMap<String, Integer> gradesIvan = new TreeMap<>();
        gradesIvan.put("Математика", 5);
        gradesIvan.put("Русский язык", 4);
        gradesIvan.put("Литература", 4);

        TreeMap<String, Integer> gradesLera = new TreeMap<>();
        gradesLera.put("Математика", 2);
        gradesLera.put("Русский язык", 4);
        gradesLera.put("Литература", 3);

        TreeMap<String, Integer> gradesDima = new TreeMap<>();
        gradesDima.put("Математика", 2);
        gradesDima.put("Русский язык", 2);
        gradesDima.put("Литература", 3);

        students.add(new Student("Иван", 1, 2, gradesIvan));
        students.add(new Student("Лера", 2, 1, gradesLera));
        students.add(new Student("Дима", 3, 3, gradesDima));

        Deanery.deleteStudent(students);
        Deanery.studentTransfer(students);
        Deanery.printStudents(students, 1);
        Deanery.printStudents(students, 2);
        Deanery.printStudents(students, 3);
    }

    
    
}