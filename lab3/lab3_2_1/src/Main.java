import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student [] students = {
                new Student(1, "Kapkin", "Ivan", "Dmitrievich", LocalDate.of(2001, 02, 12),
                        "Moscow", "+79859300594", "IU", 1, "22M"),
                new Student(1, "Awoind", "Oawnd", "Hawdja", LocalDate.of(2000, 02, 12),
                        "Spb", "+79823420594", "SM", 3, "63"),
                new Student(1, "Aawdawi", "Kajwnda", "Nawjdna", LocalDate.of(2001, 02, 12),
                        "Nsk", "+79523400594", "IU", 2, "42M"),
                new Student(1, "Iaowidjao", "Jaawid", "Najwdnawo", LocalDate.of(2002, 02, 12),
                        "York", "+79823420594", "IBM", 1, "12B"),
                new Student(1, "Nawdajn", "Adwoanon", "Kawjnajod", LocalDate.of(2000, 02, 12),
                        "Moscow", "+7234200594", "IU", 1, "22M")
        };

        System.out.println("IU students");
        for (Student student : students) {
            if (student.getFaculty() == "IU") {
                System.out.println(student.toString());
            }
        }


        System.out.println("Students for faculties and courses");
        Map<String, List<Student>> mapFaculty = new HashMap<>();
        Map<Integer, List<Student>> mapCourse = new HashMap<>();
        for (Student student : students) {
            if (!mapFaculty.containsKey(student.getFaculty())) {
                mapFaculty.put(student.getFaculty(), new ArrayList<>());
            }
            mapFaculty.get(student.getFaculty()).add(student);

            if (!mapCourse.containsKey(student.getCourse())) {
                mapCourse.put(student.getCourse(), new ArrayList<>());
            }
            mapCourse.get(student.getCourse()).add(student);
        }
        for (Map.Entry<String, List<Student>> entry : mapFaculty.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(student.toString());
            }
        }
        for (Map.Entry<Integer, List<Student>> entry : mapCourse.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(student.toString());
            }
        }

        System.out.println("Students after 2001");
        for (Student student : students) {
            if (student.getBirth().getYear() >= 2001) {
                System.out.println(student.toString());
            }
        }

        System.out.println("Students of IU 1 course Group 22M");
        for (Student student : students) {
            if (student.getFacultyCourseGroup().equals("IU 1 22M")) {
                System.out.println(student.toString());
            }
        }
    }
}

class Student {
    private int id;
    private String surname;
    private String name;
    private String lastname;
    private LocalDate birth;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;
    Student (int id, String surname, String name, String lastname, LocalDate birth,
             String address, String phone, String faculty, int course, String group) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }
    Student() {}
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return this.surname + " " + this.name + " " + this.lastname;
    }
    public void setFullName(String surname, String name, String lastname) {
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
    }
    public LocalDate getBirth() {
        return this.birth;
    }
    public void setBirth(LocalDate birth){
        this.birth = birth;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFaculty() {
        return this.faculty;
    }
    public int getCourse() {
        return this.course;
    }
    public String getFacultyCourseGroup() {
        return this.faculty + " " + this.course + " " + this.group;
    }
    public void setFacultyCourseGroup(String faculty, int course, String group) {
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }
    public String toString() {
        return "id " + this.id +
                "\tFull name: " + this.getFullName() +
                "\tbirth: " + this.birth +
                "\taddress: " + this.address +
                "\tphone: " + this.phone +
                "\tgroup: " + this.getFacultyCourseGroup();
    }
}