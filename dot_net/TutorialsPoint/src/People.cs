using System;

namespace Warehouse;

public class People
{
    protected String firstName;

    protected String lastName;

    protected DateOnly dob;

    public People(String fname, String lname, DateOnly birthdate)
    {
        this.firstName = fname;
        this.lastName = lname;
        this.dob = birthdate;
    }

    public virtual String getCSV()
    {
        return String.Format("{0},{1},{2}", firstName, lastName, dob);

    }
}

public class Employee : People
{
    int empId;

    int since;

    String title;

    public Employee(String fname, String lname, DateOnly dob, int empId, int since, String title) : base(fname, lname, dob)
    {
        this.empId = empId;
        this.since = since;
        this.title = title;
    }

    public override String getCSV()
    {
        return base.getCSV() + String.Format(",{0},{1},{2}", empId, since, title);
    }
}

public enum Membership { GOLD_STAR, EXECUTIVE};

public class Member : People
{
    long memberId;

    Membership level;

    public Member(String fname, String lname, DateOnly dob, long memberId, Membership level) : base(fname, lname, dob)
    {
        this.memberId = memberId;
        this.level = level;
    }

    public override string getCSV()
    {
        return base.getCSV() + String.Format(",{0},{1}", memberId, level);
    }
}

public class Main
{
    public static void Test1()
    {
        People fee = new People("Charles", "Fee", new DateOnly(1975, 1, 31));
        Console.WriteLine(fee.getCSV());

        People kayla = new Employee("Kayla", "Gonzalez", new DateOnly(1999, 2, 28), 654321, 2023, "CASHIER");
        Console.WriteLine(kayla.getCSV());

        People gaurav = new Member("Gaurav", "Sharma", new DateOnly(1987, 3, 4), 112043332410l, Membership.GOLD_STAR);
        Console.WriteLine(gaurav.getCSV());
    }
}