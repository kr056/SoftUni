using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WaterOverflow
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            int capacity = byte.MaxValue;
            int litersInTheTank = 0;
            for (int i = 0; i < n; i++)
            {
                int quantityWater = int.Parse(Console.ReadLine());
                litersInTheTank += quantityWater;
                if (litersInTheTank > capacity)
                {
                    Console.WriteLine("Insufficient capacity!");
                    litersInTheTank = litersInTheTank - quantityWater;
                }
            }

            Console.WriteLine(litersInTheTank);

        }
    }
}
