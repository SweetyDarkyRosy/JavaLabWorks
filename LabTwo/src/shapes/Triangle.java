package shapes;

/**
 * Представление о треугольнике.
 * <p>
 * Треуго́льник (в евклидовом пространстве) — геометрическая
 * фигура, образованная тремя отрезками, которые соединяют
 * три точки, не лежащие на одной прямой. Указанные три
 * точки называются вершинами треугольника, а отрезки —
 * сторонами треугольника. Часть плоскости, ограниченная
 * сторонами, называется внутренностью треугольника: нередко
 * треугольник рассматривается вместе со своей внутренностью
 * (например, для определения понятия площади).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Треугольник</a>
 */
public class Triangle implements Polygon
{
	/*
	 * TODO: Реализовать класс 'Triangle'
	 * 1. Используйте наследование.
	 * 2. Реализуйте все абстрактные методы.
	 */

	private float x;
	private float y;
	private int rot;
	private CPoint vertices[] = new CPoint[3];

	public Triangle(float x, float y, CPoint a, CPoint b, CPoint c)
	{
		this.x = x;
		this.y = y;

		vertices[0] = a;
		vertices[1] = b;
		vertices[2] = c;

		rot = 0;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

	public float getArea()
	{
		float a = (float)(Math.sqrt(Math.pow(vertices[1].getY() - vertices[0].getY(), 2) +
				Math.pow(vertices[1].getX() - vertices[0].getX(), 2)));
		float b = (float)(Math.sqrt(Math.pow(vertices[2].getY() - vertices[1].getY(), 2) +
				Math.pow(vertices[2].getX() - vertices[1].getX(), 2)));
		float c = (float)(Math.sqrt(Math.pow(vertices[0].getY() - vertices[2].getY(), 2) +
				Math.pow(vertices[0].getX() - vertices[2].getX(), 2)));

		float pHalf = (a + b + c) / 2;
		float area = (float)(Math.sqrt(pHalf * (pHalf - a) * (pHalf - b) * (pHalf - c)));

		return area;
	}

	public int getRotation()
	{
		return rot;
	}

	public float getPerimeter()
	{
		float perimeter = 0;

		perimeter += Math.sqrt(Math.pow(vertices[1].getY() - vertices[0].getY(), 2) +
				Math.pow(vertices[1].getX() - vertices[0].getX(), 2));
		perimeter += Math.sqrt(Math.pow(vertices[2].getY() - vertices[1].getY(), 2) +
				Math.pow(vertices[2].getX() - vertices[1].getX(), 2));
		perimeter += Math.sqrt(Math.pow(vertices[0].getY() - vertices[2].getY(), 2) +
				Math.pow(vertices[0].getX() - vertices[2].getX(), 2));

		return perimeter;
	}
}
