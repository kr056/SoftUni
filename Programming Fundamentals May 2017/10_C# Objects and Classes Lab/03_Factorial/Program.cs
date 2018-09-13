using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace _03_Factorial
{
    class Program
    {
        static void Main(string[] args)
        {

            BigInteger factorial = int.Parse(Console.ReadLine());
            BigInteger result = 1;

            for (BigInteger i = factorial; i >= 1; i--)
            {
                result *= i;
            }
            Console.WriteLine(result);
        }
    }
}
