using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace _07_MultiplyBigNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string num1 = Console.ReadLine();
            string num2 = Console.ReadLine();
            if (int.Parse(num2) == 0)
            {
                Console.WriteLine("0");
            }
            else
            {
                Console.WriteLine(Multiply(num1, num2));

            }

        }
        public static string Multiply(string num1, string num2)
        {

            int[] arr1 = num1.Select(x => int.Parse(x.ToString())).ToArray();
            int[] arr2 = num2.Select(x => int.Parse(x.ToString())).ToArray();
            var sum = new List<int>();

            int remainder = 0;
            for (int i = num1.Length - 1; i >= 0; i--)
            {
                int total = arr1[i] * arr2[0] + remainder;
                sum.Add(total % 10);

                if (total > 9)
                {
                    remainder = total / 10;
                }
                else
                {
                    remainder = 0;
                }

            }

            sum.Add(remainder);
            sum.Reverse();

            return string.Join("", sum.SkipWhile(x => x == 0));
        }
    }
}
