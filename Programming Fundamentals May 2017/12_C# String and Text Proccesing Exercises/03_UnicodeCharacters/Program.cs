using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_UnicodeCharacters
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();

            foreach (char c in input)
            {
                Console.Write("\\u");
                Console.Write(String.Format("{0:x4}", (int)c));
            }

            Console.WriteLine();
        }
    }
}
