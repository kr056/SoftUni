using System;
using System.Numerics;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FactorialTrailingZeroes
{
    class Program
    {

        static void Main(string[] args)
        {

            BigInteger n = BigInteger.Parse(Console.ReadLine());

            BigInteger factorial = 1;
            for (BigInteger i = 1; i <= n; i++)
            {
                factorial *= i;
            }

            BigInteger lastDigit = 0;
            int counter = 0;
            while (factorial > 0)
            {
                lastDigit = factorial % 10;
                if (lastDigit == 0)
                {
                    counter++;
                }
                if (lastDigit != 0)
                {
                    Console.WriteLine(counter);

                    return;
                }
                factorial /= 10;
            }
        }

    }
}

