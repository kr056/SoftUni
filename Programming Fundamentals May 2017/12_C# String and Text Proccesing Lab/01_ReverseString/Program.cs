using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_ReverseString
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine().ToCharArray();

            var reverse = String.Empty;
            for (int i = input.Length - 1; i >= 0; i--)
            {
                reverse += input[i];
            }

            Console.WriteLine(reverse);
        }
    }
}
