namespace Costco.Warehouse.Data;

public class Item
{
    public int Id { set; get; }
    public string Name { set; get; }
    public float Price { set; get; }

    public override string ToString()
    {
        return $"Item# {Id} '{Name}' ${Price}";
    }
}

public class Member
{
    public long MemberID { set; get; }
    public string FirstName { set; get; }
    public string LastName { set; get; }

    public override string ToString()
    {
        return $"{LastName}, {FirstName} (MBr# {MemberID})";
    }
}

public class Order
{
    public long OrderNo { set; get; }
    public long MemberID { set; get; }
    public string Date { set; get; }
    public int[]? Items { set; get; }
    public float Total { set; get; }

    public override string ToString()
    {
        StringWriter sw = new StringWriter();
        sw.Write("(");
        foreach (var item in Items)
        {
            sw.Write(item);
            sw.Write(",");
        }
        sw.Write(")");
        return $"Order: {OrderNo} for Member ({MemberID} on {Date} with total {Total}) having items {sw}";
    }
}
