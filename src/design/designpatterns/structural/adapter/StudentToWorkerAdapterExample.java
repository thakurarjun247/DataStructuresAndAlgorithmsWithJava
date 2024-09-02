package design.designpatterns.structural.adapter;

//application client
public class StudentToWorkerAdapterExample {
    public static void main(String[] args) {

        new Employee().paid();


        Student student= new Student();
        //won't work
        //student.paid();
        //adapting
        new StudentToWorkerAdapter(student).paid();

    }
}


//target
interface Worker{
    default public void paid() {
        System.out.println( " worker gets paid!");
    }
}

class Employee implements Worker {
    @Override
    public void paid() {
        System.out.println("employee gets paid");
    }
}



//adaptee
class Student{
void aboutme(){
    System.out.println("I am a student");
}
}
//adapter
class StudentToWorkerAdapter implements Worker{
    Student student;

    public StudentToWorkerAdapter(Student student) {
        this.student = student;
    }

    @Override
    public void paid() {
        student.aboutme();
        System.out.println("student gets paid as an worker");
    }


}


