import java.util.TreeMap;

public class Student {
    private String name;
    private int group;
    private int course;
    private TreeMap<String, Integer> grades = new TreeMap<>();

    public Student(String name, int group, int course, TreeMap<String, Integer> grades){
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public TreeMap<String, Integer> getGrades(){
        return grades;
    }
    public String getName(){
        return name;
    }
    public int getCourse(){
        return course;
    }
    
    public double getAverage(){
        double sum = 0;

        for (int grade : grades.values()) {
            sum += grade;
        }
        int gradeCount = grades.size();
        return sum / gradeCount;
    }

    public void courseUp(){
        if (getAverage() >= 3) {
            this.course++;
        }
    }

}