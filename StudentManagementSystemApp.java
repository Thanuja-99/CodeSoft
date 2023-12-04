import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade=" + grade +
                '}';
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void writeStudentsToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            System.out.println("Student data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStudentsFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Student data read from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class StudentManagementSystemApp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Students to File");
            System.out.println("6. Load Students from File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent(system, scanner);
                    break;
                case 2:
                    removeStudent(system, scanner);
                    break;
                case 3:
                    searchStudent(system, scanner);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    saveStudentsToFile(system, scanner);
                    break;
                case 6:
                    loadStudentsFromFile(system, scanner);
                    break;
                case 7:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

    private static void addStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter student grade: ");
        char grade = scanner.nextLine().charAt(0);

        Student student = new Student(name, rollNumber, grade);
        system.addStudent(student);

        System.out.println("Student added successfully.");
    }

    private static void removeStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        system.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }

    private static void searchStudent(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the roll number of the student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student student = system.searchStudent(rollNumber);

        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void saveStudentsToFile(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the file name to save students: ");
        String fileName = scanner.nextLine();

        system.writeStudentsToFile(fileName);
    }

    private static void loadStudentsFromFile(StudentManagementSystem system, Scanner scanner) {
        System.out.print("Enter the file name to load students from: ");
        String fileName = scanner.nextLine();

        system.readStudentsFromFile(fileName);
    }
}
