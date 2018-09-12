using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace livedemo
{
    class Program
    {
        static void Main(string[] args)
        {

            string typeOfDay = Console.ReadLine();
            int age = int.Parse(Console.ReadLine());
            int price = 0;

            if (age < 0 || age > 122)
            {
                Console.WriteLine("Error!");

            }
            else if (typeOfDay.Equals("Weekday"))
            {

                if (age >= 0 && age <= 18)
                {
                    price = 12;
                }
                else if (age > 18 && age <= 64)
                {
                    price = 18;
                }
                else if (age > 64 && age <= 122)
                {
                    price = 12;
                }

                Console.WriteLine($"{price}$");
            }
            else if (typeOfDay.Equals("Weekend"))
            {

                if (age >= 0 && age <= 18)
                {
                    price = 15;
                }
                else if (age > 18 && age <= 64)
                {
                    price = 20;
                }
                else if (age > 64 && age <= 122)
                {
                    price = 15;
                }

                Console.WriteLine($"{price}$");

            }
            else if (typeOfDay.Equals("Holiday"))
            {

                if (age >= 0 && age <= 18)
                {
                    price = 5;
                }
                else if (age > 18 && age <= 64)
                {
                    price = 12;
                }
                else if (age > 64 && age <= 122)
                {
                    price = 10;
                }

                Console.WriteLine($"{price}$");

            }

        }
    }
}
