using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CaloriesCounter
{
    class Program
    {
        static void Main(string[] args)
        {

            int quantity = int.Parse(Console.ReadLine());
           
            int calories = 0;           

            for (int i = 0; i < quantity; i++)
            {
                string ingredient = Console.ReadLine();
                ingredient = ingredient.ToLower();

                if (ingredient.Equals("cheese"))
                {
                    calories += 500;
                }
                else if (ingredient.Equals("tomato sauce"))
                {
                    calories += 150;
                }
                else if (ingredient.Equals("salami"))
                {
                    calories += 600;
                }
                else if (ingredient.Equals("pepper"))
                {
                    calories += 50;
                }


            }

            Console.WriteLine($"Total calories: {calories}");

        }
    }
}
