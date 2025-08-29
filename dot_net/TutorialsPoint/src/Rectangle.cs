using System;

namespace TutorialsPoint;

class Rectangle {

    private int length = 0;
    private int width = 0;

    public Rectangle() {
    }

    public Rectangle(int l, int w) {
        length = l;
        width = w;
    }

    public void SetLength(int l) {
        length = l;
    }

    public void SetWidth(int w) {
        width = w;
    }

    public int GetLength() {
        return length;
    }

    public int GetWidth() {
        return width;
    }

    public int Area() {
        return length * width;
    }

    public int Perimeter() {
        return 2*(length + width);
    }

    public void ReadLength() {
        Console.Write("Enter length of rectangle: ");
        SetLength(int.Parse(Console.ReadLine()));
    }

    public void ReadWidth() {
        Console.Write("Enter width of rectangle: ");
        SetWidth(int.Parse(Console.ReadLine()));
    }

    public void ReadDimensions() {
        ReadLength();
        ReadWidth();
    }

    public override String ToString() {
        return String.Format("Rectangle({0}X{1})", GetLength(), GetWidth());
    }
}