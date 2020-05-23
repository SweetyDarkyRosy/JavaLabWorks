package shapes;

import java.lang.Math;

import shapes.CPoint;
import shapes.Ellipse;
import shapes.Shape;

/**
 * Представление об окружности.
 * <p>
 * Окру́жность — замкнутая плоская кривая, которая состоит из
 * всех точек на плоскости, равноудалённых от заданной точки.
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9E%D0%BA%D1%80%D1%83%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C">Окружность</a>
 */
public class Circle implements Ellipse
{

	/*
	 * TODO: Реализовать класс 'Circle'
	 * 1. Используйте наследование.
	 * 2. Реализуйте все абстрактные методы.
	 */

	private float x;
	private float y;
	private float radius;

	public Circle(float x, float y, float radius)
	{
		this.x = x;
		this.y = y;

		this.radius = radius;
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
		return (float)(Math.PI * Math.pow(radius, 2));
	}

	public float getLength()
	{
		return (float)(2 * radius * Math.PI);
	}
}
