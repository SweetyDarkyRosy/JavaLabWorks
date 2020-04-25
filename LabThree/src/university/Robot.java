package university;

import java.util.concurrent.BlockingQueue;

public class Robot implements Runnable
{
    private String subjectName;
    BlockingQueue students;

    public Robot(String subjectName, BlockingQueue students)
    {
        this.subjectName = subjectName;
        this.students = students;
    }

    @Override
    public synchronized void run()
    {
        Student student;
        int studentLabsCount = 0;

        while (true)
        {
            if (students.isEmpty())
            {
                try
                {
                    System.out.println(subjectName + " robot is sleeping");
                    synchronized (students)
                    {
                        students.wait();
                    }
                } catch (InterruptedException e)
                {
                }
            }
            else
            {
                try
                {
                    student = (Student)students.take();
                    if (student.getSubjectName() == subjectName)
                    {
                        student = (Student) students.take();
                        System.out.println(subjectName + " robot has taken a student");
                        synchronized (students)
                        {
                            students.notifyAll();
                        }

                        studentLabsCount = student.getLabsCount();
                        while (studentLabsCount != 0)
                        {
                            studentLabsCount -= 5;
                            Thread.sleep(100);
                        }

                        student = null;
                    }
                }
                catch (InterruptedException e)
                {
                }
            }
        }
    }
}
