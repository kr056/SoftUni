using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilledSquare
{
    class Program
    {
        static void Main(string[] args)
        {
            PrintTriangle(int.Parse(Console.ReadLine()));

        }

        static void PrintTriangle(int n)
        {
            Console.WriteLine(Repeate("-", n * 2));

            for (int i = 0; i < n - 2; i++)
            {
                Console.Write(Repeate("-", 1));
                Console.Write(Repeate("\\/", n - 1));
                Console.WriteLine(Repeate("-", 1));

            }

            Console.WriteLine(Repeate("-", n * 2));

        }
        static string Repeate(string text, int repeatCount)
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
