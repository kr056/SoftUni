using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_CompareCharArrays
{
    class Program
    {
        static void Main(string[] args)
        {

            char[] arr1 = Console.ReadLine().
                 Split(' ').Select(char.Parse).ToArray();

            char[] arr2 = Console.ReadLine().
                 Split(' ').Select(char.Parse).ToArray();

            int sum1 = 0;

            int sum2 = 0;

            for (int i = 0; i < Math.Min(arr1.Length, arr2.Length); i++)
            {
                sum1 += arr1[i];
                sum2 += arr2[i];

            }


            if (sum1 < sum2)
            {
                for (int i = 0; i < arr1.Length; i++)
                {
                    Console.Write(arr1[i]);
                }
                Console.WriteLine();
                for (int i = 0; i < arr2.Length; i++)
                {
                    Console.Write(arr2[i]);
                }
                Console.WriteLine();

            }
            else if (sum2 < sum1)
            {
                for (int i = 0; i < arr2.Length; i++)
                {
                    Console.Write(arr2[i]);
                }
                Console.WriteLine();
                for (int i = 0; i < arr1.Length; i++)
                {
                    Console.Write(arr1[i]);
                }
                Console.WriteLine();
            }
            else if (sum1 == sum2)
            {
                if (arr1.Length < arr2.Length)
                {
                    for (int i = 0; i < arr1.Length; i++)
                    {
                        Console.Write(arr1[i]);
                    }
                    Console.WriteLine();
                    for (int i = 0; i < arr2.Length; i++)
                    {
                        Console.Write(arr2[i]);
                    }
                    Console.WriteLine();
                }
                else if (arr2.Length < arr1.Length)
                {
                    for (int i = 0; i < arr2.Length; i++)
                    {
                        Console.Write(arr2[i]);
                    }
                    Console.WriteLine();
                    for (int i = 0; i < arr1.Length; i++)
                    {
                        Console.Write(arr1[i]);
                    }
                    Console.WriteLine();
                }
                else
                {
                    for (int i = 0; i < arr2.Length; i++)
                    {
                        Console.Write(arr2[i]);
                    }
                    Console.WriteLine();
                    for (int i = 0; i < arr2.Length; i++)
                    {
                        Console.Write(arr2[i]);
                    }
                    Console.WriteLine();
                }
            }
        }
    }
}
