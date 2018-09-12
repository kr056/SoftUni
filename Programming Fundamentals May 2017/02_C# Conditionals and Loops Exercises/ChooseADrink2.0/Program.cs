using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChooseADrink
{
    class Program
    {
        static void Main(string[] args)
        {

            string proffesion = Console.ReadLine();
            double quantity = double.Parse(Console.ReadLine());
            double price = 0;


            switch (proffesion)
            {
                case "Athlete":
                    price = 0.70;
                    break;
                case "Businessman":
                case "Businesswoman":
                    price = 1.00;
                    break;
                case "SoftUni Student":
                    price = 1.70;
                    break;
                default:
                    price = 1.20;
                    break;

            }

            price = price * quantity;

            Console.WriteLine($"The {proffesion} has to pay {price:F2}.");

        }
    }
}
