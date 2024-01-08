package harsh.kachhawa;

public class Student {
    private  String name,grade;
    private   int age,id ;

    public  void setter(int id ,String name,int age,String grade)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.grade=grade;
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public String getGrade()
    {
        return grade;
    }
    public int getAge()
    {
        return age;
    }
}
