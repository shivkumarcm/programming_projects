using System;

namespace Linq;

public class LinqExample
{
    public static void Basic()
    {
        int[] gpas = new int[] { 2, 1, 4, 5, 3, 1, 5, 3, 5 };
        char[] grades = new char[] { 'F', 'E', 'D', 'C', 'B', 'A' };

        IEnumerable<char> pass =
            from gpa in gpas
            where gpa >= 3
            select grades[gpa];

        foreach (var g in pass)
        {
            Console.WriteLine(g);
        }
    }
}