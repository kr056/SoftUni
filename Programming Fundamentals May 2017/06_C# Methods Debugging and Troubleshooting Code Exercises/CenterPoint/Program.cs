using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CenterPoint
{
    class Program
    {
        static void Main(string[] args)
        {

            decimal x1 = decimal.Parse(Console.ReadLine());
            decimal y1 = decimal.Parse(Console.ReadLine());
            decimal x2 = decimal.Parse(Console.ReadLine());
            decimal y2 = decimal.Parse(Console.ReadLine());
            PrintTheClosestPoint(x1, y1, x2, y2);

        }

        static void PrintTheClosestPoint(decimal x1, decimal y1, decimal x2, decimal y2)
        {
            decimal x1Distance = Math.Abs(x1 - 0);
            decimal x2Distance = Math.Abs(x2 - 0);
            decimal y1Distance = Math.Abs(x1 - 0);
            decimal y2Distance = Math.Abs(x1 - 0);

            if (x1Distance <= x2Distance && y1Distance <= y2Distance)
            {
                Console.WriteLine($"({x1}, {y1})");
            }
            else
            {
                Console.WriteLine($"({x2}, {y2})");
            }

        }
    }
}
