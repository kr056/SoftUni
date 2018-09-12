
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_PizzaIngredients
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] ingredients = Console.ReadLine().
                Split(' ').ToArray();

            int letterLength = int.Parse(Console.ReadLine());

            int counter = 0;

            var result = new List<string>();

            for (int i = 0; i < ingredients.Length && counter < 10; i++)
            {

                if (ingredients[i].Length == letterLength)
                {
                    Console.WriteLine($"Adding {ingredients[i]}.");
                    counter++;
                    result.Add(ingredients[i]);
                }

            }

            Console.WriteLine($"Made pizza with total of {counter} ingredients.");
            Console.Write($"The ingredients are: {string.Join(", ", result)}.");

        }
    }
}


