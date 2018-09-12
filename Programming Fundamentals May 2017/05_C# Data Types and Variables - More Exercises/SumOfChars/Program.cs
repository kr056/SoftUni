using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sum
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            char symbol;
            int num = 0;
            for (int i = 0; i < n; i++)
            {
                symbol = char.Parse(Console.ReadLine());
                num += symbol;
            }

            Console.WriteLine($"The sum equals: {num}");

        }
    }
}
