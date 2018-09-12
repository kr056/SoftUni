using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace X
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            int middle = (n - 2);

            for (int i = 0; i < n / 2; i++)
            {

                Console.Write(newString(" ", i));
                Console.Write("x");
                Console.Write(newString(" ", middle));
                Console.Write("x");
                Console.WriteLine(newString(" ", i));
                middle -= 2;

            }
            middle = 1;
            Console.Write(newString(" ", (n / 2)));
            Console.Write("x");
            Console.WriteLine(newString(" ", (n / 2)));

            for (int i = (n / 2) - 1; i >= 0; i--)
            {
                Console.Write(newString(" ", i));
                Console.Write("x");
                Console.Write(newString(" ", middle));
                Console.Write("x");
                Console.WriteLine(newString(" ", i));
                middle += 2;
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
