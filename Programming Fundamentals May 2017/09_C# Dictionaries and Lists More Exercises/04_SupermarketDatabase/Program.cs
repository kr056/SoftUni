using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_SupermarketDatabase
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine();

            var database = new Dictionary<string, Dictionary<double, double>>();

            double total = 0;

            while (input != "stocked")
            {

                var tokens = input.Split();
                var productName = tokens[0];
                var productPrice = double.Parse(tokens[1]);
                var productQuantity = double.Parse(tokens[2]);

                if (!database.ContainsKey(productName))
                {
                    database[productName] = new Dictionary<double, double>();
                }

                if (!database[productName].ContainsKey(productPrice))
                {
                    database[productName][productPrice] = 0;
                }

                database[productName][productPrice] += productQuantity;

                input = Console.ReadLine();
            }

            foreach (var data in database)
            {
                var name = data.Key;
                var price = data.Value.Keys.Last();
                var quantity = data.Value.Values.Sum();
                total += (quantity * price);

                Console.WriteLine($"{name}: ${price:F2} * {quantity} = ${quantity * price:F2}");
            }

            Console.WriteLine("------------------------------");
            Console.WriteLine($"Grand Total: ${total:f2}");

        }
    }
}
