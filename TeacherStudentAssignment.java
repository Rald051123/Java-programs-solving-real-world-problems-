import java.util.ArrayList;

// Person class
class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}

// Student class inheriting from Person
class Student extends Person {
    private final String studentId;

    public Student(String name, int age, String gender, String studentId) {
        super(name, age, gender);
        this.studentId = studentId;
    }

    public void displayStudent() {
        System.out.println("--- Student Information ---");
        displayInfo();
        System.out.println("Student ID: " + studentId);
    }
}

// Course class
record Course(String courseCode, String courseName) {
    public void displayCourse() {
        System.out.println("   " + courseCode + courseName);
    }
}

// Teacher class inheriting from Person
class Teacher extends Person {
    private final String department;
    private final ArrayList<Course> courses; // HAS-A relationship

    public Teacher(String name, int age, String gender, String department) {
        super(name, age, gender);
        this.department = department;
        this.courses = new ArrayList<>();
    }

    // Add a course to the teacher
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayTeacher() {
        System.out.println("---Teacher Information ---");
        displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Courses Handled:");
        for (Course course : courses) {
            course.displayCourse();
        }
        System.out.println("---------------------------");
    }
}

// Main class
public class TeacherStudentAssignment {
    static void main(String[] args) {
        // Create a student
        Student student1 = new Student("Ana Santos", 19, "Female", "S1023");
        student1.displayStudent();

        // Create courses
        Course comp = new Course("CS101 - ", "Programming Fundamentals");
        Course comp1 = new Course("CS102 - ", "Object-Oriented Programming");

        // Create a teacher and assign courses
        Teacher teacher1 = new Teacher("Mr. Dela Cruz", 45, "Male", "Computer Studies");
        teacher1.addCourse(comp);
        teacher1.addCourse(comp1);

        teacher1.displayTeacher();
        comp.displayCourse();
    }
}
