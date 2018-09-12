using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BeerKegs
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            double result = 0;
            string output = "";
            double max = 0;
            for (int i = 0; i < n; i++)
            {
                string model = Console.ReadLine();
                double radius = double.Parse(Console.ReadLine());
                int height = int.Parse(Console.ReadLine());
                result = Math.PI * radius * radius * height;
                if (result > max)
                {
                    max = result;
                    output = model;
                }

            }

            Console.WriteLine(output);

        }
    }
}
