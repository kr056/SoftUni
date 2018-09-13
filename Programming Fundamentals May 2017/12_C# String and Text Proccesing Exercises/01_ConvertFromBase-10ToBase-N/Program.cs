using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace _01_ConvertFromBase_10ToBase_N
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine().Split().ToArray();

            var baseNToConvert = BigInteger.Parse(input[0]);
            var number = BigInteger.Parse(input[1]);

            var result = String.Empty;

            while (true)
            {
                BigInteger remainder = number % baseNToConvert;
                number = number / baseNToConvert;
                result += remainder.ToString();
                if (number <= 0)
                {
                    break;
                }

            }

            var reverse = Reverse(result);

            Console.WriteLine(reverse);
        }

        static string Reverse(string num)
        {
            var input = num.ToCharArray();

            var reverse = String.Empty;

            for (int i = input.Length - 1; i >= 0; i--)
            {
                reverse += input[i];
            }
            return reverse;
        }
    }
}
