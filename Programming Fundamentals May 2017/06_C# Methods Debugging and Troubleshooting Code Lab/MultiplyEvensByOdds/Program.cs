using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MultiplyEvensByOdds
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int result = MultiplyEvenByOdd(Math.Abs(n));
            Console.WriteLine(result);

        }

        static int MultiplyEvenByOdd(int n)
        {
            int evenSum = 0;
            int oddSum = 0;
            while (n > 0)
            {
                int lastDigit = n % 10;
                if (lastDigit % 2 == 0)
                {
                    evenSum += lastDigit;
                }
                else if (lastDigit % 2 != 0)
                {
                    oddSum += lastDigit;
                }
                n /= 10;
            }

            return evenSum * oddSum;
        }
    }
}
