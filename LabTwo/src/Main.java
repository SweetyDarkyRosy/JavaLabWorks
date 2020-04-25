import shapes.*;

public class Main
{
    public static int getMaxAreaShape(Shape[] shapes)
    {
        int hIndex = 0;
        float area = 0;

        for (int i = 0; i < shapes.length; i++)
        {
            if (area < shapes[i].getArea())
            {
                area = shapes[i].getArea();
                hIndex = i;
            }
        }

        return hIndex;
    }

    public static void main(String[] args)
    {
        Shape[] shapes = new Shape[10];

        shapes[0] = new Rectangle(43, 7, new CPoint(3, 49), new CPoint(80, 49),
                new CPoint(80, 1), new CPoint(3, 1));

        shapes[1] = new Rectangle(57, 9, new CPoint(34, 49), new CPoint(76, 49),
                new CPoint(76, 2), new CPoint(34, 2));

        shapes[2] = new Rectangle(0, 0, new CPoint(-2, 19), new CPoint(4, 19),
                new CPoint(4, 0), new CPoint(-2, 0));

        shapes[3] = new Triangle(3, 9, new CPoint(-4, 0), new CPoint(1, 16),
                new CPoint(15, 0));

        shapes[4] = new Triangle(10, 1, new CPoint(-1, 0), new CPoint(11, 23),
                new CPoint(16, -24));

        shapes[5] = new Triangle(3, 9, new CPoint(-4, 0), new CPoint(1, 16),
                new CPoint(15, -43));

        shapes[6] = new Circle(3, 9, 5);

        shapes[7] = new Circle(5, 324, 12);

        shapes[8] = new Circle(23, 74, 54);

        shapes[9] = new Circle(1, 76, 6);

        System.out.println("Shape with biggest area index: " + getMaxAreaShape(shapes));

        /*
         * TODO: Выполнить действия над массивом 'shapes'
         *
         * 1. Проинициализировать переменную 'shapes' массивом
         *    содержащим 10 произвольных фигур. Массив должен
         *    содержать экземпляры классов Circle, Rectangle
         *    и Triangle.
         *
         * 2. Найти в массиве 'shapes' фигуру с максимальной
         *    площадью. Для поиска фигуры необходимо создать
         *    статический метод в текущем классе (Main).
         */
    }
}
