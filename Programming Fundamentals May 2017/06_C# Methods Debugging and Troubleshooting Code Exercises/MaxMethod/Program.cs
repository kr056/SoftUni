using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaxMethod
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int c = int.Parse(Console.ReadLine());
            int max = GetMax(a, b);

            if (c >= max)
            {
                Console.WriteLine(c);
            }
            else
            {
                Console.WriteLine(max);
            }

        }

        static int GetMax(int a, int b)
        {
            int max = 0;
            if (a >= b)
            {
                max = a;
            }
            else
            {
                max = b;
            }
            return max;
        }

    }
}
