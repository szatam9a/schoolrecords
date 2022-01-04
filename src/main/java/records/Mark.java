package records;

public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        checkOnCreate(subject,tutor);
        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        checkOnCreate(subject,tutor);
        this.markType = MarkType.valueOf(markType);
        this.subject = subject;
        this.tutor = tutor;
        System.out.println(markType);
    }

    @Override
    public String toString() {

        return markType.toString();
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }
    private void checkOnCreate(Subject subject, Tutor tutor){
        if (subject==(null) || tutor==(null)){
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
    }
}
