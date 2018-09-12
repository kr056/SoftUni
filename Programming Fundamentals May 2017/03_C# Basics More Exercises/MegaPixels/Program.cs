using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaPixels
{
    class Program
    {
        static void Main(string[] args)
        {

            int width = int.Parse(Console.ReadLine());
            int height = int.Parse(Console.ReadLine());

            double megaPixels = (width * height) / 1000000.0;

            Console.WriteLine($"{width}x{height} => {Math.Round(megaPixels, 1)}MP");

        }
    }
}
