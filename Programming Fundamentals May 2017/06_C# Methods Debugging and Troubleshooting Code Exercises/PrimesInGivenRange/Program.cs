using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrimesInGivenRange
{
    class Program
    {
        static void Main(string[] args)
        {

            int startNum = int.Parse(Console.ReadLine());
            int endNum = int.Parse(Console.ReadLine());

            var primes = FindPrimesInRange(startNum, endNum);

            Console.WriteLine(string.Join(", ", primes));

        }

        private static List<int> FindPrimesInRange(int startNum, int endNum)
        {
            var primes = new List<int>();


            for (int currentNum = startNum; currentNum <= endNum; currentNum++)
            {
                if (isPrime(currentNum))
                {
                    primes.Add(currentNum);
                }
            }
            return primes;
        }

        static bool isPrime(long number)
        {

            bool isPrime = true;

            for (int i = 2; i <= Math.Sqrt(number); i++)
            {
                if (number % i == 0)
                {
                    return false;

                }

            }

            if (number == 0 || number == 1)
            {
                return false;
            }


            return true;
        }
    }
}
