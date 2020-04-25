package university;

public class Student
{
    private int labsCount;
    private String subjectName;

    public Student(int labsCount, String subjectName)
    {
        this.labsCount = labsCount;
        this.subjectName = subjectName;
    }

    public int getLabsCount()
    {
        return labsCount;
    }

    public String getSubjectName()
    {
        return subjectName;
    }
}
