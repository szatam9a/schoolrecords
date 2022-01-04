package records;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SchoolRecordsController {
    private ClassRecords classRecords;
    private List<Tutor> tutors = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<String> menu = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String button;

    public SchoolRecordsController(ClassRecords classRecords) {
        this.classRecords = classRecords;

    }

    void initSchool() {
        System.out.println(this.classRecords);
        readMenu();
        writeMenu();
        infiniteLoop();
    }

    private void readMenu() {
        try {
            menu = Files.readAllLines(Path.of("src/main/java/menu.txt"));
        } catch (IOException io) {
            throw new IllegalArgumentException("no file to read");
        }
    }

    private void writeMenu() {
        for (String s : menu
        ) {
            System.out.println(s);
        }
    }

    private void read(){
        button = sc.nextLine();
    }

    private void infiniteLoop() {
        read();
        while (!button.trim().equals("11")) {
            switch (button) {
                case "1":
                    System.out.println(classRecords.getStudentList());
                    break;
                case "2":
                    System.out.println("gyerek név?");
                    read();
                    System.out.println(classRecords.findStudentByName(button));
                    break;
                case "3":
                    System.out.println("gyerek név?");
                    read();
                    classRecords.addStudent(new Student(button));
                    break;
                case "4":
                    System.out.println("gyerek név?");
                    read();
                    System.out.println(classRecords.removeStudent(classRecords.findStudentByName(button)));
                    break;
                case "5":
                    Student badluck = classRecords.repetition();
                    System.out.println("Felel ma" + badluck);
                    break;
                case "6":
                    System.out.println(classRecords.calculateClassAverage());
                    break;
                case "7":
                    read();
                    System.out.println(classRecords.calculateClassAverageBySubject(new Subject(button)));
                    break;
                case "8":
                    System.out.println(classRecords.listStudyResults());
                    break;
                case "9":
                    System.out.println("diák?");
                    read();
                    System.out.println(classRecords.findStudentByName(button).calculateAverage());
                    break;
                case "10":
                    System.out.println("diák?");
                    read();
                    System.out.println("tantárny?");
                    String subject = sc.nextLine();
                    System.out.println(classRecords.findStudentByName(button).calculateSubjectAverage(new Subject(subject)));
                    break;
            }
            writeMenu();
            read();
        }
        System.out.println("byebye");
    }
    public static void main(String[] args) {
        SchoolRecordsController src = new SchoolRecordsController(new ClassRecords("Napsugár", new Random()));
        src.initSchool();
    }
}
