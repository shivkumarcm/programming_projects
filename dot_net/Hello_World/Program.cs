// See https://aka.ms/new-console-template for more information
//Console.WriteLine("Hello, World!");

using MyFirstProject;

namespace Global;
internal class Program {
    public static void Main(string[] args) {
        HelloWorld.printIt();

        Console.Write("Enter a number: ");
        int a = int.Parse(Console.ReadLine() ?? "0");

        Console.Write("Enter another number: ");
        int b = int.Parse(Console.ReadLine() ?? "0");
    
        Console.WriteLine("{0} + {1} = {2}", a, b, NumFunctions.Add(a, b));

        Console.Write("Enter another number: ");
        int c = int.Parse(Console.ReadLine() ?? "0");
    
        NumFunctions.MultTablePrinter(c);
    }
}