using System;

namespace MyFirstProject;

public class NumFunctions {

    public static int Add(int a, int b) {
        int c;
        c = a + b;
        return c;
    }

    public static void MultTablePrinter(int num) {

        for(int i = 1; i <= 10; i++) {
            int prod = num * i;
            Console.WriteLine($"{num} X {i} = {prod}");
        }
    }
}
