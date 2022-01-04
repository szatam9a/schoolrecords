package records;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random random;
    private List<Student> studentList = new ArrayList<>();

    public ClassRecords(String name, Random random) {
        this.className = name;
        this.random = random;
    }

    public boolean addStudent(Student student) {
        if (findStudentByName(studentList, student) == null) {
            studentList.add(student);
            return true;
        }
        return false;
    }

    private Student findStudentByName(List<Student> list, Student student) {
        for (Student s : list) {
            if (s.getName().equals(student.getName())) {
                return s;
            }
        }
        return null;
    }

    public boolean removeStudent(Student student) {
        if (checkTheListToNull(studentList)) throw new NullPointerException("no student");
        if (findStudentByName(studentList, student) != null) {
            studentList.remove(findStudentByName(studentList, student));
            return true;
        } else return false;
    }

    public double calculateClassAverage() {
        if (checkTheListToNull(studentList))
            throw new ArithmeticException("No student in the class, average calculation aborted!");

        double summer = 0;
        for (Student s : studentList) {
            if (checkTheListToNull(s.getMarks())) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
            summer += s.calculateAverage();
        }
        return twoDecimal(summer / studentList.size());
    }


    public double calculateClassAverageBySubject(Subject subject) {
        if (checkTheListToNull(studentList)) throw new NullPointerException("no student");
        double summer = 0;
        int counter = 0;
        for (Student s : studentList) {
            if (s.calculateSubjectAverage(subject) != 0) {
                summer += s.calculateSubjectAverage(subject);
                counter++;
            }
        }
        return twoDecimal(summer / counter);
    }

    public Student findStudentByName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (checkTheListToNull(studentList)) throw new IllegalStateException("No students to search!");

        for (Student s : studentList) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public Student repetition() {

        if (checkTheListToNull(studentList)) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return studentList.get(random.nextInt(studentList.size()));
    }

    public List<StudyResultByName> listStudyResults() {

        if (checkTheListToNull(studentList)) throw new NullPointerException("no student");
        List<StudyResultByName> result = new ArrayList<>();
        for (Student s : studentList) {
            result.add(new StudyResultByName(s.getName(), s.calculateAverage()));
        }
        return result;
    }

    public String listStudentNames() {
        if (checkTheListToNull(studentList)) throw new NullPointerException("no student");

        StringBuilder sb = new StringBuilder();
        for (Student s : studentList) {
            sb.append(s.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    private boolean checkTheListToNull(List list) {
        if (list.size() == 0 || list == null) {
            return true;
        } else
            return false;
    }

    public String getClassName() {
        return className;
    }

    public List<Student> getStudentList() {
        if (checkTheListToNull(studentList)) {
            throw new NullPointerException("Empty list");
        }
        return studentList;
    }

    static public double twoDecimal(double number) {
        return ((Math.round(number * 100.0)) / 100.0);
    }
    public Random getRandom() {
        return random;
    }
}
