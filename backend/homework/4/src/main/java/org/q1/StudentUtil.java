package org.q1;

import logger.Log;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
         if (studentIdList.length != studentsGrades.length) {
             Log.warning("Length of Student Id and Student Grade Array Dont match");

            throw new IllegalArgumentException("StudentIdList & StudentsGrades length dont match. studentIdList length: "
                    + studentIdList.length + ", studentsGrades length: " + studentsGrades.length);
        }
        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = 0.0;
            for (int j = 0; j < studentsGrades[i].length; j++) {
                if (studentsGrades[i][j] == 'A') {
                    gpa += 4.0;
                } else if (studentsGrades[i][j] == 'B') {
                    gpa += 3.0;
                } else if (studentsGrades[i][j] == 'C') {
                    gpa += 2.0;
                } else if (studentsGrades[i][j] == ' ') {
                    Log.warning("Empty Grade Passed");
                    throw new MissingGradeException(studentIdList[i]);
                }
            }

            gpaList[i] = gpa / studentsGrades[i].length;
        }

        return gpaList;
    }


    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) throws MissingGradeException, InvalidDataException {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaList = new double[studentIdList.length];

        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException e) {
            Log.warning(e.getMessage());
            throw new InvalidDataException("Invalid data encountered", e);
        }

        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }
        return result;
    }
}