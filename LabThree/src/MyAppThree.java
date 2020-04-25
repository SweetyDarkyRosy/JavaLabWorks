import java.util.concurrent.*;
import university.Robot;
import university.Student;
import university.StudentGenerator;

public class MyAppThree
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        BlockingQueue students = new ArrayBlockingQueue<Student>(10);

        Robot robotMaths = new Robot("Maths", students);
        Robot robotOop = new Robot("OOP", students);
        Robot robotPhysics = new Robot("Physics", students);

        StudentGenerator studentGen = new StudentGenerator(students);

        executorService.execute(studentGen);
        executorService.execute(robotMaths);
        executorService.execute(robotOop);
        executorService.execute(robotPhysics);
    }
}
