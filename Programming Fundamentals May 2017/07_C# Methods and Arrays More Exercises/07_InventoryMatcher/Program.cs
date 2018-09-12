using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_InventoryMatcher
{
    class Program
    {
        static void Main(string[] args)
        {

            var productNames = Console.ReadLine().Split(' ').ToArray();
            long[] productQuantity = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
            decimal[] productPrice = Console.ReadLine().Split(' ').Select(decimal.Parse).ToArray();

            while (true)
            {
                var product = Console.ReadLine();
                if (product == "done")
                {
                    return;
                }
                for (int i = 0; i < productNames.Length; i++)
                {
                    if (product.Equals(productNames[i]))
                    {
                        string result = $"{productNames[i]} costs: {productPrice[i]}; Available quantity: {productQuantity[i]}";
                        Console.WriteLine(result);
                    }
                }

            }

        }
    }
}
