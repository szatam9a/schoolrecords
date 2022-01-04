package records;

import java.util.Objects;

public class Subject {
    private String subjectName;

    Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return Objects.equals(getSubjectName(), subject.getSubjectName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubjectName());
    }

    @Override
    public String toString() {
        return subjectName ;
    }
}
