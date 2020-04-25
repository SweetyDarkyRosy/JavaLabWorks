/*
* Viktoriia Pashchenko | JAVA | Lab 1
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class MyApp
{
    public static boolean strToInt(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean isPrime(int i)
    {
        if (i <= 1)
        {
            return false;
        }
        else if (i <= 3)
        {
            return true;
        }
        else if (i % 2 == 0 || i % 3 == 0)
        {
            return false;
        }

        int n = 5;
        while (n * n <= i)
        {
            if (i % n == 0 || i % (n + 2) == 0)
            {
                return false;
            }
            n += 6;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int min = 0, max = 0;
        String str;

        System.out.println("Enter min: ");
        while (!strToInt(str = scan.next()))
        {
            System.out.println("Enter integer number! Enter min: ");
        }
        min = Integer.parseInt(str);

        System.out.println("Enter max: ");
        while (!strToInt(str = scan.next()))
        {
            System.out.println("Enter integer number! Enter max: ");
        }
        max = Integer.parseInt(str);
        scan.close();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        if (max < min)
        {
            int tempInt = max;
            max = min;
            min = tempInt;
        }

        for (int i = min; i <= max; i++)
        {
            if (isPrime(i))
            {
                System.out.println(i + " is a prime number");
            }
        }
    }
}
