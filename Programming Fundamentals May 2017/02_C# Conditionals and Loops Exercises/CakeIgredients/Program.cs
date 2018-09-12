using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CakeIgredients
{
    class Program
    {
        static void Main(string[] args)
        {
            string ingredient = Console.ReadLine();

            Console.WriteLine($"Adding ingredient {ingredient}.");

            for (int i = 1; i <= 20; i++)
            { 
                 ingredient = Console.ReadLine();
                if (ingredient.Equals("Bake!"))
                {
                    Console.WriteLine($"Preparing cake with {i} ingredients.");
                    break;
                }
                Console.WriteLine($"Adding ingredient {ingredient}.");

            }

        }
    }
}
