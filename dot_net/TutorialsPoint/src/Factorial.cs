namespace TutorialsPoint;

public class Factorial
{
    public int Compute(int number)
    {
        if (number < 0)
        {
            return 0;
        }
        switch (number)
        {
            case 0: return 1;
            case 1: return 1;
            default: return number * Compute(number - 1);
        }
    }
}