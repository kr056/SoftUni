using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11_EqualSums
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] arr = Console.ReadLine().
            Split(' ').Select(int.Parse).ToArray();

            int leftSum = 0;
            int rightSum = 0;
            int counter = 0;

            for (int currentNum = 0; currentNum < arr.Length; currentNum++)
            {
                for (int numsToLeft = currentNum - 1; numsToLeft >= 0; numsToLeft--)
                {
                    leftSum += arr[numsToLeft];
                }
                for (int numsToRight = arr.Length - 1; numsToRight > currentNum; numsToRight--)
                {
                    rightSum += arr[numsToRight];
                }

                if (rightSum == leftSum)
                {
                    Console.WriteLine(currentNum);
                    counter++;
                }

                leftSum = 0;
                rightSum = 0;

            }

            if (counter == 0)
            {
                Console.WriteLine("no");
            }

        }
    }
}
