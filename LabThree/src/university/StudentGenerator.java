package university;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class StudentGenerator implements Runnable
{
    BlockingQueue students;
    Random rand;

    public StudentGenerator(BlockingQueue students)
    {
        this.students = students;
        rand = new Random();
    }

    private Student getStudent()
    {
        int labsCount = 0;
        String subjectName = "";

        int randInt = rand.nextInt(3);
        switch (randInt)
        {
            case 0:
                labsCount = 10;
                break;
            case 1:
                labsCount = 20;
                break;
            case 2:
                labsCount = 100;
                break;
        }

        randInt = rand.nextInt(3);
        switch (randInt)
        {
            case 0:
                subjectName = "Maths";
                break;
            case 1:
                subjectName = "OOP";
                break;
            case 2:
                subjectName = "Physics";
                break;
        }

        System.out.println("New student is generated. Subject: " + subjectName + ". Labs count: " + labsCount);
        return new Student(labsCount, subjectName);
    }

    @Override
    public synchronized void run()
    {
        while (true)
        {
            if (students.size() == 10)
            {
                try
                {
                    System.out.println("Student generator is sleeping");
                    synchronized (students)
                    {
                        students.wait();
                    }
                }
                catch (InterruptedException e)
                {
                }
            }
            else
            {
                try
                {
                    students.put(getStudent());
                    System.out.println("Count of students: " + students.size());
                    synchronized (students)
                    {
                        students.notifyAll();
                    }
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                }
            }
        }
    }
}
