package org.q1;

public class MissingGradeException extends Exception {
    private final int studentId;
    MissingGradeException(int studentId)
    {
        super("Grades are missing for the StudentId "+studentId);
        this.studentId=studentId;
    }
    public int getStudentId()
    {
        return studentId;
    }

}
