using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_UpgradedMatcher
{
    class Program
    {
        static void Main(string[] args)
        {
            var productNames = Console.ReadLine().Split(' ').ToArray();
            var productQuantity = Console.ReadLine().Split(' ').Select(long.Parse).ToList();
            decimal[] productPrice = Console.ReadLine().Split(' ').Select(decimal.Parse).ToArray();

            var diff = productNames.Length - productQuantity.Count;
            for (int i = 0; i < diff; i++)
            {
                productQuantity.Add(0);
            }

            long quantityNeeded = 0;

            while (true)
            {
                var product = Console.ReadLine().Split(' ').ToArray();

                if (product[0] == "done")
                {

                    return;
                }

                quantityNeeded = long.Parse(product[1]);

                for (int i = 0; i < productNames.Length; i++)
                {
                    if (product[0].Equals(productNames[i]))
                    {
                        if (quantityNeeded <= productQuantity[i])
                        {
                            productQuantity[i] -= quantityNeeded;

                            decimal totalPrice = quantityNeeded * (decimal)productPrice[i];

                            Console.WriteLine($"{productNames[i]} x {quantityNeeded} costs {totalPrice:F2} ");
                        }
                        else
                        {
                            Console.WriteLine($"We do not have enough {productNames[i]}");
                        }
                    }
                }

            }

        }
    }
}
