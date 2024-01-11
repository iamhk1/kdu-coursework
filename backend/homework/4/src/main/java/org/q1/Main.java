package org.q1;

import logger.Log;

public class Main {
    public static void main(String []args) throws MissingGradeException {
        int[] ids = {1001, 1002};
        char[][] grades = {{'A', 'B'}, {'A', ' '}};
        try {
            int[] ans = StudentUtil.getStudentsByGPA(2.5,3.5,ids, grades);
        }
        catch (Exception e){
            Log.info(e.getMessage());
        }
    }

}
