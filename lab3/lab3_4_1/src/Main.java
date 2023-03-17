import java.util.*;
public class Main {
    public static void main(String[] args) {
        Tutor [] tutors = {
            new Tutor("Stepanov P.V."),
            new Tutor("Papulin S.Yu.")
        };
        Course [] courses = {
            tutors[0].announceCourse("Programming languages for work with big data"),
            tutors[0].announceCourse("Languages of internet programming"),
            tutors[1].announceCourse("Methods of machine learning")
        };
        Student [] students = {
            new Student("Kapkin I.D."),
            new Student("Barishpol I.L.")
        };
        for (Student student : students) for (Course course : courses) student.enlist(course);
        for (Student student : students) for (Course course : courses) student.study(course);
        for (Tutor tutor : tutors) for (Student student : students) for (Course course : courses) tutor.evaluate(student, course);

        for (Student student : students) System.out.println(student.toString());
    }
}
class Tutor {
    private List<Course> courses;
    public String name;
    private Random evaluator;
    public Tutor (String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.evaluator = new Random(Calendar.getInstance().getTimeInMillis());
    }
    public Course announceCourse (String name) {
        Course course = new Course(name);
        this.courses.add(course);
        return course;
    }
    public boolean evaluate (Student student, Course course) {
        return student.graduate(course, evaluator.nextInt(60, 100));
    }
}
class Student {
    private Map<Course, Integer> marks;
    public String name;
    public Student (String name) {
        this.name = name;
        this.marks = new HashMap<>();
    }
    public void enlist (Course course) {
        this.marks.put(course, null);
    }
    public boolean study (Course course) {
        return this.marks.containsKey(course);
    }
    public boolean graduate (Course course, int mark) {
        if (this.marks.containsKey(course)) {
            this.marks.put(course, mark);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.name + marks.toString();
    }
}
class Course {
    public String name;
    public Course (String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}