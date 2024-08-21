package org.q1;

import java.util.logging.Logger;

public class StudentUtil {
    static Logger logger= Logger.getLogger(String.valueOf(StudentUtil.class));
    public static double []calculateGPA(int []studentIdList,char[][]studentsGrades)
    {

        int totalStudents=studentIdList.length;
        double []gpa=new double[totalStudents];
        if(totalStudents==0||studentsGrades.length==0)
            return gpa;
        for(int i=0;i<totalStudents;i++)
        {
            int totalcredits=0;
            for(int j=0;j<studentsGrades[i].length;j++)
            {
                char grade=studentsGrades[i][j];
                if(grade=='A')
                    totalcredits+=4;
                else if(grade=='B')
                    totalcredits+=3;
                else if(grade=='C')
                    totalcredits+=2;

            }
            double studGpa=totalcredits/(studentsGrades[i].length*1.0);
            gpa[i]=studGpa;
        }
        return gpa;

    }
    public static int[]getStudentsByGPA(double lower,double higher,int []studentIdList,char[][]studentsGrades)
    {
        if(lower<0||lower>4||higher<lower||higher>4||higher<0)
        {
            return new int[0];
        }
        double []gpa=calculateGPA(studentIdList,studentsGrades);

        logger.info("GPA List");
        for(double i:gpa) {

            logger.info(""+i);
        }

        int totStudentsInRange=0;
        int totalstudents=studentIdList.length;
        for(int i=0;i<totalstudents;i++)
        {
            if(gpa[i]>=lower&&gpa[i]<=higher)
                ++totStudentsInRange;
        }

        int []idList=new int[totStudentsInRange];
        int index=0;
        for(int i=0;i<totalstudents;i++)
        {
            if(gpa[i]>=lower&&gpa[i]<=higher)
            {
                idList[index++]=studentIdList[i];
            }
        }
        return idList;
    }
    public static void main(String []args)
    {

        int []studentIdList={1001,1002,1003};
        char [][]studentsGrades={{'A','A','B','C'},{'A','A','B',' '},{'A','B','B','C'}};
        double lower=2.8;
        double upper=3.5;
        int []idList=getStudentsByGPA(lower,upper,studentIdList,studentsGrades);
        logger.info("The List of Student Id's is:");
        for(int i:idList){
            logger.info(i+" ");
        }
    }
}
