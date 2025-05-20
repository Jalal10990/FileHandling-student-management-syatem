import java.io.*;
import java.util.*;

// Student class
class StudentManagementSystem {
    String name;
    int marks;

    // Constructor
    StudentManagementSystem(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Convert student info to string
    public String toString() {
        return name + ", " + marks;
    }
}

// Manager class to handle file operations
class StudentManager {

    // Method to write student list to file
    void writeToFile(ArrayList<StudentManagementSystem> students, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (StudentManagementSystem s : students) {
                writer.write(s.toString() + "\n");
            }
            writer.close();
            System.out.println("✅ Students written to file successfully.\n");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read student data from file
    void readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("📄 Student Data From File:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error reading from file: " + e.getMessage());
        }
    }
}

// Main class
public class main{
    public static void main(String[] args) {
        ArrayList<StudentManagementSystem> studentList = new ArrayList<>();

        // Create some students
        studentList.add(new StudentManagementSystem("Ali", 88));
        studentList.add(new StudentManagementSystem("Sara", 93));
        studentList.add(new StudentManagementSystem("Ahmed", 76));

        // File name
        String fileName = "students_oop.txt";

        // Create StudentManager object
        StudentManager manager = new StudentManager();

        // Write and Read
        manager.writeToFile(studentList, fileName);
        manager.readFromFile(fileName);
    }
}