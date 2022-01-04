package records;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        } else {
            marks.add(mark);
        }
    }

    public double calculateAverage() {
        if (marks == null) {
            throw new IllegalArgumentException("empty marks list");
        }
        double summer = 0;

        for (Mark mark : marks) {
            summer += mark.getMarkType().getValue();
        }
        return ClassRecords.twoDecimal(summer / marks.size());
    }

    public double calculateSubjectAverage(Subject subject) {
        if (marks == null) {
            throw new IllegalArgumentException("empty marks list");
        }
        double summer = 0;
        int counter =0;
        for (Mark mark : marks) {
            if (mark.getSubject().equals(subject)) {
                summer += mark.getMarkType().getValue();
                counter++;
            }
        }
        return ClassRecords.twoDecimal(summer / counter);
    }

    public String toString() {
        if (marks.isEmpty()){
            return name;
        }
        else
        return name + " marks: "+marks.get(0).getSubject()+": "+marks.get(0);
    }

    public String getName() {
        return name;
    }

    public List<Mark> getMarks() {
        return marks;
    }
}
