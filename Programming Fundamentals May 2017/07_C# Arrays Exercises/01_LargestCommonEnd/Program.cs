using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_LargestCommonEnd
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] arr1 = Console.ReadLine().
                 Split(' ').ToArray();

            string[] arr2 = Console.ReadLine().
                Split(' ').ToArray();

            int leftCount = 0;
            int rightCount = 0;
            int size = Math.Min(arr1.Length, arr2.Length);

            for (int i = 0; i < size; i++)
            {

                if (arr1[i] == arr2[i])
                {
                    leftCount++;
                }

                if (arr1[arr1.Length - 1 - i] == arr2[arr2.Length - 1 - i])
                {
                    rightCount++;
                }

            }

            Console.WriteLine(Math.Max(leftCount, rightCount));
        }
    }
}
