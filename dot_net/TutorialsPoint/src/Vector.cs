using System;

namespace Geometry;

public class Vector
{
    int x;

    int y;

    public Vector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector() : this(0, 0)
    {
    }

    public override string ToString()
    {
        return $"({x},{y})";
    }

    public static Vector operator +(Vector v1, Vector v2)
    {
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }

    public static Vector operator -(Vector v1, Vector v2)
    {
        return new Vector(v1.x - v2.x, v1.y - v2.y);
    }

    public static Vector operator -(Vector v)
    {
        return new Vector(-v.x, -v.y);
    }

    public static Vector operator *(Vector v, int i)
    {
        return new Vector(v.x * i, v.y * i);
    }

    public static Vector operator ++(Vector v)
    {
        v.x++;
        v.y++;
        return v;
    }
}

public class Tester
{
    public static void MainTest()
    {
        Vector v1 = new (3, 4);
        Vector v2 = new (5, 6);
        Vector sum = v1 + v2;
        Vector diff = v1 - v2;
        Vector neg = -v1;

        Console.WriteLine("v1 = " + v1);
        Console.WriteLine("v2 = " + v2);
        Console.WriteLine("v1 + v2 = " + (v1 + v2));
        Console.WriteLine("v1 - v2 = " + diff);
        Console.WriteLine("-v1 = " + neg);
        Console.WriteLine("v1++ = " + v1++);
        Console.WriteLine("++v1 = " + ++v1);
        Console.WriteLine("v1*3 = " + v1*3);
    }
}