using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TriangleOfNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                Console.WriteLine(newString($"{i} ", i));
            }

        }
        public static String newString(string text, int repeatCount)
        {
            string a = "";
            for (int i = 0; i < repeatCount; i++)
            {
                a += text;
            }
            return a;
        }

    }
}
