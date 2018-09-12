using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_RotateAndSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().
                Split(' ').Select(int.Parse).ToArray();

            int rotations = int.Parse(Console.ReadLine());

            int[] sum = new int[arr.Length];

            for (int i = 0; i < rotations; i++)
            {
                Rotate(arr);

                for (int j = 0; j < arr.Length; j++)
                {
                    sum[j] += arr[j];
                }
            }
            Console.WriteLine(string.Join(" ", sum));


        }

        static void Rotate(int[] arr1)
        {
            int oldElement;
            oldElement = arr1[arr1.Length - 1];

            for (int i = arr1.Length - 1; i > 0; i--)
            {
                arr1[i] = arr1[i - 1];
            }
            arr1[0] = oldElement;

        }
    }
}
