using System;
using System.IO;
using YamlDotNet.Serialization;
using Costco.Warehouse.Data;
using System.Collections;
using YamlDotNet.Core;
using YamlDotNet.Core.Events;

public class Program
{
    static Hashtable items, members, orders;

    static void InitData() {

        Item watermelon = new Item();
        watermelon.Id = 4032;
        watermelon.Name = "Watermelon";
        watermelon.Price = 5.99f;

        Item chicken = new Item();
        chicken.Id = 87745;
        chicken.Name = "Rottiserie Chicken";
        chicken.Price = 4.99f;

        Item ksWater = new Item();
        ksWater.Id = 80102;
        ksWater.Name = "KS Water";
        ksWater.Price = 3.99f;

        items = new Hashtable();
        items.Add(watermelon.Id, watermelon);
        items.Add(chicken.Id, chicken);
        items.Add(ksWater.Id, ksWater);

        Member jack = new Member();
        jack.MemberID = 11200048523L;
        jack.FirstName = "Jack";
        jack.LastName = "Ma";
        Member jane = new Member();
        jane.MemberID = 11100340356L;
        jane.FirstName = "Jane";
        jane.LastName = "Doe";
        Member sean = new Member();
        sean.MemberID = 30000340396L;
        sean.FirstName = "Sean";
        sean.LastName = "Ray";

        members = new Hashtable();
        members.Add(jack.MemberID, jack);
        members.Add(jane.MemberID, jane);
        members.Add(sean.MemberID, sean);

        Order order1 = new Order();
        order1.MemberID = jack.MemberID;
        order1.OrderNo = 23424242L;
        order1.Date = "01/31/2025";
        order1.Items = new int[] { watermelon.Id, chicken.Id };
        order1.Total = 1.1f * (watermelon.Price + chicken.Price);

        Order order2 = new Order();
        order2.MemberID = jane.MemberID;
        order2.OrderNo = 23426532L;
        order2.Date = "08/30/2025";
        order2.Items = new int[] { watermelon.Id, ksWater.Id };
        order2.Total = 1.1f * (watermelon.Price + ksWater.Price);

        orders = new Hashtable();
        orders.Add(order1.OrderNo, order1);
        orders.Add(order2.OrderNo, order2);
    }

    static void SerializeData(string filename, Hashtable data)
    {
        var serializer = new Serializer();

        FileStream datacache = new FileStream(filename, FileMode.OpenOrCreate);
        StreamWriter writer = new StreamWriter(datacache);

        writer.Write(serializer.Serialize(data));
        writer.Close();
        datacache.Close();
    }

    public static Hashtable DeserializeData<V>(string filepath)
    {
        Hashtable retval = new Hashtable();
        FileStream cache = new FileStream(filepath, FileMode.Open, FileAccess.Read);
        StreamReader reader = new StreamReader(cache);

        Parser parser = new Parser(reader);
        var deserializer = new Deserializer();

        parser.Consume<StreamStart>();
        parser.Consume<DocumentStart>();
        parser.Consume<MappingStart>();

        while (parser.TryConsume<Scalar>(out var key))
        {
            //Value is of type string
            retval.Add(key.Value, deserializer.Deserialize<V>(parser));
        }
        return retval;
    }

    public static void Main(string[] args)
    {
        InitData();
        SerializeData("items.yaml", items);
        SerializeData("members.yaml", members);
        SerializeData("orders.yaml", orders);

        Hashtable cacheItems = DeserializeData<Item>("items.yaml");
        Hashtable cacheMembers = DeserializeData<Member>("members.yaml");
        Hashtable cacheOrders = DeserializeData<Order>("orders.yaml");

        Console.WriteLine("### Items ###");
        foreach (var key in cacheItems.Keys)
        {
            Console.WriteLine($"{key}: {cacheItems[key]}");
        }

        Console.WriteLine("### Members ###");
        foreach (var key in cacheMembers.Keys)
        {
            Console.WriteLine($"{key}: {cacheMembers[key]}");
        }

        Console.WriteLine("### Orders ###");
        foreach (var key in cacheOrders.Keys)
        {
            Console.WriteLine($"{key}: {cacheOrders[key]}");
        }

    }

}