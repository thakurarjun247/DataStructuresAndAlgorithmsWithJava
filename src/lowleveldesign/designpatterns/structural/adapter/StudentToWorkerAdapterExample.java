package lowleveldesign.designpatterns.structural.adapter;

/*Key Elements of the Adapter Pattern:
Target Interface (Worker): This defines the method paid() that the client expects.
Adaptee (Student): This is the existing class that doesn’t have the paid() method but instead has aboutme().
Adapter (StudentToWorkerAdapter): This is where the actual adaptation occurs.
It implements the Worker interface and translates the method paid() by calling aboutme() and then adding its own logic to adapt the behavior.
//target*/
interface Worker {
    void paid();
}

//application client
public class StudentToWorkerAdapterExample {
    public static void main(String[] args) {

        new Employee().paid();


        Student student = new Student();
        //won't work
        //student.paid();
        //adapting
        new StudentToWorkerAdapter(student).paid();

    }
}

class Employee implements Worker {
    @Override
    public void paid() {
        System.out.println("employee gets paid");
    }
}


//adaptee
class Student {
    void aboutme() {
        System.out.println("I am a student");
    }
}

//adapter
class StudentToWorkerAdapter implements Worker {
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


