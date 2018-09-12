using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CubeProperties
{
    class Program
    {
        static void Main(string[] args)
        {
            double side = double.Parse(Console.ReadLine());
            string param = Console.ReadLine();
            PrintCubeProp(side, param);
        }

        static void PrintCubeProp(double side, string param)
        {
            double face = 0;
            double space = 0;
            double volume = 0;
            double area = 0;


            switch (param)
            {
                case "face":
                    face = Math.Sqrt(2 * side * side);
                    Console.WriteLine($"{face:F2}");
                    break;
                case "space":
                    space = Math.Sqrt(3 * side * side);
                    Console.WriteLine($"{space:F2}");
                    break;
                case "volume":
                    volume = side * side * side;
                    Console.WriteLine($"{volume:F2}");
                    break;
                case "area":
                    area = 6 * side * side;
                    Console.WriteLine($"{area:F2}");
                    break;

            }
        }
    }
}
