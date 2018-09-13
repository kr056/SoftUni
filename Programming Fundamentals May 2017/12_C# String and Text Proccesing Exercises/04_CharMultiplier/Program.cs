using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_CharMultiplier
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine().Split().ToArray();

            Console.WriteLine(GetSum(input[0], input[1]));

        }

        static int GetSum(string first, string second)
        {
            var arr1 = first.ToCharArray();
            var arr2 = second.ToCharArray();
            var sum = 0;
            var size = 0;

            if (arr1.Length > arr2.Length)
            {
                size = arr2.Length;
                var addToSum = first.Substring(size, first.Length - size).ToCharArray();
                for (int i = 0; i < addToSum.Length; i++)
                {
                    sum += (int)addToSum[i];
                }
            }
            else if (arr2.Length > arr1.Length)
            {
                size = arr1.Length;
                var addToSum2 = second.Substring(size, second.Length - size).ToCharArray();
                for (int i = 0; i < addToSum2.Length; i++)
                {
                    sum += (int)addToSum2[i];
                }
            }
            else
            {
                size = arr1.Length;
            }

            for (int i = 0; i < size; i++)
            {
                sum += (int)(arr1[i] * arr2[i]);
            }

            return sum;
        }
    }
}
