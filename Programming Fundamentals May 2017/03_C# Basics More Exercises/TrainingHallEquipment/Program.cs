using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrainingHallEquipment
{
    class Program
    {
        static void Main(string[] args)
        {

            double budget = double.Parse(Console.ReadLine());
            int itemNumber = int.Parse(Console.ReadLine());
            double itemsSum = 0;

            for (int i = 0; i < itemNumber; i++)
            {
                string itemName = Console.ReadLine();
                double itemPrice = double.Parse(Console.ReadLine());
                int itemCount = int.Parse(Console.ReadLine());
                itemsSum += (itemPrice * itemCount);

                if (itemCount > 1)
                {
                    Console.WriteLine($"Adding {itemCount} {itemName}s to cart.");
                }
                else
                {
                    Console.WriteLine($"Adding {itemCount} {itemName} to cart.");
                }

            }

            if (itemsSum <= budget)
            {
                Console.WriteLine($"Subtotal: ${itemsSum:F2}");
                Console.WriteLine($"Money left: ${(budget - itemsSum):F2}");
            }
            else if (itemsSum > budget)
            {
                Console.WriteLine($"Subtotal: ${itemsSum:F2}");
                Console.WriteLine($"Not enough. We need ${(itemsSum - budget):F2} more.");
            }

        }
    }
}
