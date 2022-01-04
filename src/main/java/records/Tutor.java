package records;

import java.util.List;

public class Tutor {
    private String name;

    public String getName() {
        return name;
    }

    public List<Subject> getTaughtSubjects() {
        return taughtSubjects;
    }

    private List<Subject> taughtSubjects;

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        if (taughtSubjects.contains(subject)) {
            return true;
        } else
            return false;
    }
}
