using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace _06_SumBigNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            string num1 = Console.ReadLine();
            string num2 = Console.ReadLine();
            Console.WriteLine(Add(num1, num2));

        }

        public static string Add(string num1, string num2)
        {
            int maxLen = Math.Max(num1.Length, num2.Length);
            num1 = num1.PadLeft(maxLen + 1, '0');
            num2 = num2.PadLeft(maxLen + 1, '0');

            int[] arr1 = num1.Select(x => int.Parse(x.ToString())).ToArray();
            int[] arr2 = num2.Select(x => int.Parse(x.ToString())).ToArray();
            int[] sum = new int[arr1.Length];

            int carry = 0;

            for (int i = sum.Length - 1; i >= 0; i--)
            {
                int total = arr1[i] + arr2[i] + carry;
                sum[i] = total % 10;
                if (total > 9)
                {
                    carry = 1;
                }
                else
                {
                    carry = 0;
                }
            }

            return string.Join("", sum.SkipWhile(x => x == 0));
        }
    }
}
