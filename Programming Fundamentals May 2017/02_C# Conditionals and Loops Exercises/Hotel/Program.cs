using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hotel
{
    class Program
    {
        static void Main(string[] args)
        {

            string month = Console.ReadLine();
            int nights = int.Parse(Console.ReadLine());

            double studio = 0;
            double two = 0;
            double suite = 0;
            double priceStudio = 0;
            double priceDouble = 0;
            double priceSuite = 0;

            if (month.Equals("May") || month.Equals("October"))
            {

                studio = 50;
                two = 65;
                suite = 75;

            }
            else if (month.Equals("June") || month.Equals("September"))
            {

                studio = 60;
                two = 72;
                suite = 82;

            }
            else if (month.Equals("July") || month.Equals("August") || month.Equals("December"))
            {

                studio = 68;
                two = 77;
                suite = 89;

            }         

            if(nights>7 && (month.Equals("May") || month.Equals("October")))
            {
               studio *= 0.95;
            }
            else if (nights > 14 && (month.Equals("June") || month.Equals("September")))
            {
                two *= 0.90;
            }
            else if (nights > 14 && (month.Equals("July") || month.Equals("August")
                || month.Equals("December")))
            {
                suite *= 0.85;
            }

            priceStudio = studio * nights;
            priceDouble = two * nights;
            priceSuite = suite * nights;

            if (nights>7 && (month.Equals("September") || month.Equals("October")))
            {
                priceStudio = priceStudio - studio;
            }

            Console.WriteLine($"Studio: {priceStudio:F2} lv.");
            Console.WriteLine($"Double: {priceDouble:F2} lv.");
            Console.WriteLine($"Suite: {priceSuite:F2} lv.");

        }
    }
}
