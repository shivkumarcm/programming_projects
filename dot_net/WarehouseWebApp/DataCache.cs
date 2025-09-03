using System;
using System.IO;
using YamlDotNet.Serialization;
using Costco.Warehouse.Data;
using System.Collections;
using YamlDotNet.Core;
using YamlDotNet.Core.Events;

public class DataCache
{

    const string DATA_FOLDER = "data/";
    const string ITEMS_FILE = DATA_FOLDER + "items.yaml";
    const string MEMBERS_FILE = DATA_FOLDER + "members.yaml";
    const string ORDERS_FILE = DATA_FOLDER + "orders.yaml";

    public static Hashtable Items, Members, Orders;

    public static void InitData()
    {
        Items = DeserializeData<Item>(ITEMS_FILE);
        Members = DeserializeData<Member>(MEMBERS_FILE);
        Orders = DeserializeData<Order>(ORDERS_FILE);
    }

    public static void SaveData()
    {
        SerializeData(ITEMS_FILE, Items);
        SerializeData(MEMBERS_FILE, Members);
        SerializeData(ORDERS_FILE, Orders);
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
            retval.Add(key.Value, deserializer.Deserialize<V>(parser));
        }
        return retval;
    }

    public static void PrintData()
    {
        Console.WriteLine("### Items ###");
        foreach (var key in Items.Keys)
        {
            Console.WriteLine($"{key}: {Items[key]}");
        }

        Console.WriteLine("### Members ###");
        foreach (var key in Members.Keys)
        {
            Console.WriteLine($"{key}: {Members[key]}");
        }

        Console.WriteLine("### Orders ###");
        foreach (var key in Orders.Keys)
        {
            Console.WriteLine($"{key}: {Orders[key]}");
        }
    }

}