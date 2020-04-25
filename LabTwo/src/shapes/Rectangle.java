package shapes;

import java.lang.Math;

import shapes.CPoint;
import shapes.Polygon;
import shapes.Shape;
import shapes.Point;

/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
public class Rectangle implements Polygon
{

	/*
	 * TODO: Реализовать класс 'Rectangle'
	 * 1. Используйте наследование.
	 * 2. Реализуйте все абстрактные методы.
	 */

	private float x;
	private float y;
	private int rot;
	private CPoint vertices[] = new CPoint[4];

	public Rectangle(float x, float y, CPoint a, CPoint b, CPoint c, CPoint d)
	{
		this.x = x;
		this.y = y;

		vertices[0] = a;
		vertices[1] = b;
		vertices[2] = c;
		vertices[3] = d;

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
		float area;

		float sideOne = (float)(Math.sqrt(Math.pow(vertices[1].getY() - vertices[0].getY(), 2) +
				Math.pow(vertices[1].getX() - vertices[0].getX(), 2)));
		float sideTwo = (float)(Math.sqrt(Math.pow(vertices[2].getY() - vertices[1].getY(), 2) +
				Math.pow(vertices[2].getX() - vertices[1].getX(), 2)));

		area = sideOne * sideTwo;
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
		perimeter += Math.sqrt(Math.pow(vertices[3].getY() - vertices[2].getY(), 2) +
				Math.pow(vertices[3].getX() - vertices[2].getX(), 2));
		perimeter += Math.sqrt(Math.pow(vertices[0].getY() - vertices[3].getY(), 2) +
				Math.pow(vertices[0].getX() - vertices[3].getX(), 2));

		return perimeter;
	}
}
