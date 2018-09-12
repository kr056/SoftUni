using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrimeChecker
{
    class Program
    {
        static void Main(string[] args)
        {
            long n = long.Parse(Console.ReadLine());
            PrimeCheck(n);

        }

        static void PrimeCheck(long number)
        {

            bool isPrime = true;

            for (int i = 2; i <= Math.Sqrt(number); i++)
            {
                if (number % i == 0)
                {
                    isPrime = false;

                }

            }
            if (number == 0 || number == 1)
            {
                isPrime = false;
            }

            Console.WriteLine(isPrime);

        }
    }
}
