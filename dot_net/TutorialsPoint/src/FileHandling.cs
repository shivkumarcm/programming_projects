using System;
using System.Formats.Tar;
using System.IO;

namespace FileHandling;

public class MyFileHandler
{
    string filename;

    public string Filename
    {
        set { filename = value; }
        get { return filename; }
    }

    public MyFileHandler(string fname)
    {
        filename = fname;
    }

    public void Append(string line)
    {
        FileStream fstream = new FileStream(filename, FileMode.Append, FileAccess.Write);
        StreamWriter writer = new StreamWriter(fstream);
        writer.WriteLine(line);
        writer.Close();
        fstream.Close();
    }

    public void Print()
    {
        FileStream fstream = new FileStream(filename, FileMode.OpenOrCreate, FileAccess.Read);
        StreamReader reader = new StreamReader(fstream);
        Console.WriteLine($"### Printing file {filename} ###");
        int linecount = 0;
        while (!reader.EndOfStream)
        {
            string line = reader.ReadLine() ?? "";
            Console.WriteLine(line);
            linecount++;
        }
        Console.WriteLine($"### End (Total {linecount} lines) ###");
        reader.Close();
        fstream.Close();
    }

    /**
     * set/get ith line in a file. Put empty lines if needed.
     */
    public string this[int index]
    {
        get
        {
            FileStream fstream = new FileStream(filename, FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader reader = new StreamReader(fstream);
            int linecount = 0;
            while (!reader.EndOfStream)
            {
                string line = reader.ReadLine() ?? "";
                if (index == linecount)
                {
                    reader.Close();
                    fstream.Close();
                    return line;
                }
                linecount++;
            }
            reader.Close();
            fstream.Close();
            return "";
        }

        set
        {
            FileStream basefstream = new FileStream(filename, FileMode.OpenOrCreate, FileAccess.Read);
            FileStream targetfstream = new FileStream("temp.txt", FileMode.OpenOrCreate, FileAccess.Write);

            StreamReader reader = new StreamReader(basefstream);
            StreamWriter writer = new StreamWriter(targetfstream);
            int linecount = 0;
            while (linecount < index && !reader.EndOfStream)
            {
                writer.WriteLine(reader.ReadLine());
                linecount++;
            }

            if (linecount == index)
            {
                writer.WriteLine(value); // write this line into the output
                reader.ReadLine(); // omit this line from the input;
                while (!reader.EndOfStream)
                {
                    writer.WriteLine(reader.ReadLine());
                }
            }
            else // file has fewer lines
            {
                while (linecount < index) // add empty new lines
                {
                    writer.WriteLine("");
                    linecount++;
                }
                writer.WriteLine(value);
            }
            writer.Close();
            reader.Close();
            basefstream.Close();
            targetfstream.Close();
            File.Move("temp.txt", filename, true);
        }
    }
}

public class FileHandlerTester
{
    public static void TestAppend()
    {
        MyFileHandler fh = new MyFileHandler("test.txt");
        fh.Append("This is a test line.");
        fh.Append("This is another test line.");
        fh.Append("And a third test line.");
    }

    public static void TestPrint()
    {
        MyFileHandler fh = new MyFileHandler("test.txt");
        fh.Print();
    }

    public static void TestGet()
    {
        MyFileHandler fh = new MyFileHandler("test.txt");
        Console.WriteLine("0th line of file is: " + fh[0]);
        Console.WriteLine("3rd line of file is: " + fh[3]);
        Console.WriteLine("22nd line of file is: " + fh[22]);
    }

    public static void TestSet()
    {
        MyFileHandler fh = new("test.txt");
        fh[1] = "Overwriting line 1 with this one";
        Console.WriteLine("1st line of file is now: " + fh[1]);
        fh[10] = "Overwriting line 10 with this one - the other case";
        Console.WriteLine("10th line of file is now: " + fh[10]);
        fh[30] = "Overwriting line 30 with this one - new test";
        Console.WriteLine("30th line of file is now: " + fh[30]);
    }

    public static void TestAll()
    {
        TestAppend();
        TestPrint();
        TestGet();
        TestSet();
    }
}