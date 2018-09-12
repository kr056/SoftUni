using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_SumArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr1 = Console.ReadLine().
                Split(' ').Select(int.Parse).ToArray();

            int[] arr2 = Console.ReadLine().
                Split(' ').Select(int.Parse).ToArray();

            int firstArrLen = arr1.Length;
            int secondArrLen = arr2.Length;
            int max = Math.Max(firstArrLen, secondArrLen);
            int[] sum = new int[max];
            for (int i = 0; i < sum.Length; i++)
            {
                sum[i] = arr1[i % firstArrLen] + arr2[i % secondArrLen];
                Console.WriteLine(sum[i]);

            }
        }
    }
}
