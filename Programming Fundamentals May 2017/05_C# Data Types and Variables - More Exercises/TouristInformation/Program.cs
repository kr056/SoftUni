using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TouristInformation
{
    class Program
    {
        static void Main(string[] args)
        {

            string imperialUnit = Console.ReadLine();
            double value = double.Parse(Console.ReadLine());
            double result = 0;

            switch (imperialUnit)
            {
                case "miles":
                    result = value * 1.6;
                    Console.WriteLine("{0} miles = {1:F2} kilometers", value, result);
                    break;
                case "inches":
                    result = value * 2.54;
                    Console.WriteLine("{0} inches = {1:F2} centimeters", value, result);
                    break;
                case "feet":
                    result = value * 30;
                    Console.WriteLine("{0} feet = {1:F2} centimeters", value, result);
                    break;
                case "yards":
                    result = value * 0.91;
                    Console.WriteLine("{0} yards = {1:F2} meters", value, result);
                    break;
                case "gallons":
                    result = value * 3.8;
                    Console.WriteLine("{0} gallons = {1:F2} liters", value, result);
                    break;
            }
        }
    }
}
