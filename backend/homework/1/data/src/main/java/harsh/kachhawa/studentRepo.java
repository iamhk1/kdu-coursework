package harsh.kachhawa;
import java.util.*;
public class studentRepo {
    static ArrayList<Student>stud=new ArrayList<Student>();

    public  static void addStudent(int id,String name,int age,String grade)
    {
        Student ob=new Student();
        ob.setter(id,name,age,grade);
        stud.add(ob);
        Log.setLogger("New Student Added Successfully");
    }
    public static void update(int id,String name ,int age ,String grade)
    {
            int index=-1;
            for(Student s:stud)
            {
                ++index;
                if(s.getId()==id) {
                    break;
                }
            }
            Student tmp=new Student();
            tmp.setter(id,name,age,grade);
            if(index<stud.size()) {

                stud.set(index, tmp);
                System.out.println("Updated user:");
                System.out.println("Roll: "+tmp.getId()+" "+",Name: "+tmp.getName()+" "+",Age: "+tmp.getAge()+" "+",Grade: "+tmp.getGrade());
            }
            else {
                System.out.println("Roll Number not present");
                Log.setLogger("Wrong Roll Number");
            }
    }
    public static Student retreive(int id)
    {

        Student ans=null;
        for(Student s:stud)
        {
            if(s.getId()==id)
            {
                ans=s;
                break;
            }
        }
        return ans;
    }
    public static Student retreive(String name)
    {
        Student ans=null;
        for(Student s:stud)
        {
            if(s.getName().equals(name))
            {
                ans=s;
                break;
            }
        }
        return ans;
    }
}
