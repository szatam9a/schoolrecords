package records;

public class StudyResultByName {
    private String StudentName;
    private double studyAverage;

    public double getStudyAverage() {
        return studyAverage;
    }

    public StudyResultByName(String name, double studentAverage) {
        this.StudentName = name;
        this.studyAverage = studentAverage;
    }

    public String getStudentName() {
        return StudentName;
    }
}
