using System;

namespace TutorialsPoint;

enum Department { FRONT_END, MEMBER_SERVICE, MEMBERSHIP, BAKERY, DELI}

enum Job { CASHIER, CASH_AST, SUP, MGR };

struct Employee {
    public string Name;
    public int Since;

    public Department Dept;
    public Job Role;

    public override string ToString()
    {
        return Name.ToUpper() + " (Employee since " + Since + ") " + Dept.ToString() + " " + Role.ToString();
    }
}

class Program {

    static void RectangleMain() {
        Rectangle rect = new Rectangle();
        rect.ReadDimensions();
        Console.WriteLine(rect);
        Console.WriteLine("Rectangle Area: " + rect.Area());
        Console.WriteLine("Rectangle Perimeter: " + rect.Perimeter());
    }

    static void EmployeeMain() {
        Employee emp1;
        emp1.Name = "Jobee";
        emp1.Since = 2005;
        emp1.Dept = Department.FRONT_END;
        emp1.Role = Job.CASHIER;
        Console.WriteLine(emp1);

        Employee emp2;
        emp2.Name = "Sabrina";
        emp2.Since = 2019;
        emp2.Dept = Department.DELI;
        emp2.Role = Job.SUP;
        Console.WriteLine(emp2);
    }

    static void TypeMain()
    {
        int i = 5;
        Console.WriteLine(i.ToString());

        float f = 23.342f;
        Console.WriteLine(Convert.ToInt32(f));

        string pi = "3.142857";
        Console.WriteLine(double.Parse(pi));
        try
        {
            Console.WriteLine(int.Parse(pi));
        }
        catch (Exception e)
        {
            Console.WriteLine("Exception while parsing int: " + e.Message);
        } 
    }

    static void FactorialMain()
    {
        int num;

        do
        {
            Console.Write("Enter a number (-1 to break): ");
            num = int.Parse(Console.ReadLine() ?? "1");
            Console.WriteLine("{0}! = {1}", num, new Factorial().Compute(num));

        }
        while (num != -1);
    }

    static void ArraysMain()
    {
        int[] arr = new int[10];

        for (int i = 0; i < arr.Length; i++)
        {
            arr[i] = new Factorial().Compute(i);
        }

        for (int i = 0; i < arr.Length; i++)
        {
            Console.WriteLine("arr[{0}] = {1}", i, arr[i]);
        }
    }

    static void MatrixMain()
    {
        int rows, cols;
        int[][] matrix;

        Console.Write("Enter number of rows: ");
        rows = int.Parse(Console.ReadLine() ?? "5");

        Console.Write("Enter number of columns: ");
        cols = int.Parse(Console.ReadLine() ?? "5");

        matrix = new int[rows][];
        for (int i = 0; i < rows; i++)
        {
            matrix[i] = new int[cols];
        }

        for (int i = 0; i < matrix.Length; i++)
        {
            for (int j = 0; j < matrix[i].Length; j++)
            {
                matrix[i][j] = (i+1) * (j+1);
            }
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                Console.Write("{0,3} ", matrix[i][j]);
            }
            Console.WriteLine("\n");
        }
    }

    static void Main(String[] args)
    {
        Console.WriteLine("Hello, Shiv!");

        //RectangleMain();

        //EmployeeMain();

        //TypeMain();

        //FactorialMain();

        //ArraysMain();

        MatrixMain();
    }
}