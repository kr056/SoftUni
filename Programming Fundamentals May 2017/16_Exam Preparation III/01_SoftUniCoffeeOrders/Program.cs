using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace _01_SoftUniCoffeeOrders
{
    class Program
    {
        static void Main(string[] args)
        {
            var ordersCount = int.Parse(Console.ReadLine());

            decimal totalprice = 0;

            for (int i = 0; i < ordersCount; i++)
            {
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());

                var orderDate = Console.ReadLine().Split('/');
                var month = int.Parse(orderDate[1]);
                var year = int.Parse(orderDate[2]);
                var daysInMonth = System.DateTime.DaysInMonth(year, month);

                decimal capsulesCount = decimal.Parse(Console.ReadLine());

                decimal price = daysInMonth * capsulesCount * pricePerCapsule;

                Console.WriteLine($"The price for the coffee is: ${price:f2}");

                totalprice += price;
            }

            Console.WriteLine($"Total: ${totalprice:f2}");
        }
    }
}
