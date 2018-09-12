using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RestaurantDiscount
{
    class Program
    {
        static void Main(string[] args)
        {

            int groupSize = int.Parse(Console.ReadLine());
            string package = Console.ReadLine();
            double price = 0;
            double servicePrice = 0;
            double discount = 0;
            double total = 0;
            string hall = "";

            if (groupSize <= 50)
            {
                hall = "Small Hall";
                price = 2500;

                if (package.Equals("Normal"))
                {
                    servicePrice = 500;
                    discount = (price + servicePrice) * 0.05;
                }
                else if (package.Equals("Gold"))
                {
                    servicePrice = 750;
                    discount = (price + servicePrice) * 0.10;
                }
                else if (package.Equals("Platinum"))
                {
                    servicePrice = 1000;
                    discount = (price + servicePrice) * 0.15;
                }
                total = ((price + servicePrice) - discount) / groupSize;
                Console.WriteLine($"We can offer you the {hall}");
                Console.WriteLine($"The price per person is {total:F2}$");

            }

            else if (groupSize > 50 && groupSize <= 100)
            {
                hall = "Terrace";
                price = 5000;

                if (package.Equals("Normal"))
                {
                    servicePrice = 500;
                    discount = (price + servicePrice) * 0.05;
                }
                else if (package.Equals("Gold"))
                {
                    servicePrice = 750;
                    discount = (price + servicePrice) * 0.10;
                }
                else if (package.Equals("Platinum"))
                {
                    servicePrice = 1000;
                    discount = (price + servicePrice) * 0.15;
                }
                total = ((price + servicePrice) - discount) / groupSize;
                Console.WriteLine($"We can offer you the {hall}");
                Console.WriteLine($"The price per person is {total:F2}$");

            }

            else if (groupSize > 100 && groupSize <= 120)
            {
                hall = "Great Hall";
                price = 7500;

                if (package.Equals("Normal"))
                {
                    servicePrice = 500;
                    discount = (price + servicePrice) * 0.05;
                }
                else if (package.Equals("Gold"))
                {
                    servicePrice = 750;
                    discount = (price + servicePrice) * 0.10;
                }
                else if (package.Equals("Platinum"))
                {
                    servicePrice = 1000;
                    discount = (price + servicePrice) * 0.15;
                }
                total = ((price + servicePrice) - discount) / groupSize;
                Console.WriteLine($"We can offer you the {hall}");
                Console.WriteLine($"The price per person is {total:F2}$");

            }
            else
            {
                Console.WriteLine("We do not have an appropriate hall.");
            }
        }
    }
}
