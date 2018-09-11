using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Beverage_Labels
{
    class Program
    {
        static void Main(string[] args)
        {

            string name = Console.ReadLine();
            int ml = int.Parse(Console.ReadLine());
            int energyContentPer100ml = int.Parse(Console.ReadLine());
            int sugarContentPer100ml = int.Parse(Console.ReadLine());

            double energy = (ml / 100.0) * energyContentPer100ml;
            double sugar = (ml / 100.0) * sugarContentPer100ml;


            Console.WriteLine($"{ml}ml {name}:");
            Console.WriteLine($"{energy}kcal, {sugar}g sugars");

        }
    }
}
