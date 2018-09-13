using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace _02_ConvertFromBase_NToBase_10
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine().Split().ToArray();

            var baseN = int.Parse(input[0]);
            var num = input[1].ToCharArray();

            BigInteger result = 0;

            for (int i = 0; i < num.Length; i++)
            {
                var parsedNum = BigInteger.Parse(num[num.Length - 1 - i].ToString());
                result += parsedNum * BigInteger.Pow(baseN, i);
            }

            Console.WriteLine(result);

        }
    }
}
