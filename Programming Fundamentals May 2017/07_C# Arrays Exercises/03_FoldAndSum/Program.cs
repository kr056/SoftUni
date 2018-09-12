using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_FoldAndSum
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] arr = Console.ReadLine().
                Split(' ').Select(int.Parse).ToArray();

            var k = arr.Length / 4;
            var leftArr = new int[k];
            var middleArr = new int[k * 2];
            var rightArr = new int[k];

            var resultArr = new int[k * 2];

            for (int i = 0; i < k; i++)
            {
                leftArr[i] = arr[i];
                rightArr[i] = arr[3 * k + i];
            }

            for (int i = 0; i < 2 * k; i++)
            {
                middleArr[i] = arr[k + i];
            }

            Array.Reverse(leftArr);
            Array.Reverse(rightArr);

            for (int i = 0; i < k; i++)
            {
                resultArr[i] += leftArr[i] + middleArr[i];

                resultArr[i + k] += middleArr[i + k] + rightArr[i];
            }

            Console.WriteLine(string.Join(" ", resultArr));

        }
    }
}
