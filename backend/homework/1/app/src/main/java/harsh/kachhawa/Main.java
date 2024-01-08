package harsh.kachhawa;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("Enter 0 to exit \nEnter 1 to add student \n2 to update student \n3 to retreive information via roll number \n4 to retreive information via name");
            int choice=sc.nextInt();
            if(choice==0)
                break;
            Student newobj=new Student();
            if(choice==1)
            {
                System.out.println("Enter the id , name , age and grade of the student");
                int id,age;
                String name,grade;
                id=sc.nextInt();
                name=sc.next();
                age=sc.nextInt();
                grade=sc.next();
                studentRepo.addStudent(id,name,age,grade);

            }
            else if(choice==2)
            {
                System.out.println("Enter the Roll Number of the student to be updated");
                int roll=sc.nextInt();
                System.out.println("Enter the Updated name, grade and age");
                String name=sc.next();
                String grade=sc.next();
                int age=sc.nextInt();
                studentRepo.update(roll,name,age,grade);
                System.out.println("\n");

            }
            else if(choice ==3)
            {
                System.out.println("Enter the roll number to search ");
                int roll=sc.nextInt();
                newobj=studentRepo.retreive(roll);
                System.out.println("\n");
                if(newobj==null) {
                    System.out.println("Student with this roll number does not exist");
                    Log.setLogger("No user with this Roll Number is Present");
                }
                else {
                    System.out.println("The details are as follows");
                    System.out.println("Roll: "+newobj.getId()+" "+",Name: "+newobj.getName()+" "+" ,Age: "+newobj.getAge()+" "+",Grade: "+newobj.getGrade());
                }
                System.out.println("\n");
            }
            else
            {
                System.out.println("Enter the Name to search");
                String name=sc.next();
                newobj= studentRepo.retreive(name);
                System.out.println("\n");
                if(newobj==null) {
                    System.out.println("Student with this name number does not exist");
                    Log.setLogger("No Student with this Name is present.");
                }
                else {
                    System.out.println("The details are as follows");
                    System.out.println("Roll: "+newobj.getId()+" "+",Name: "+newobj.getName()+" "+",Age: "+newobj.getAge()+" "+",Grade: "+newobj.getGrade());
                }
                System.out.println("\n");
            }
        }

    }
}