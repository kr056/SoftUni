using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10_PairsByDifference
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] arr = Console.ReadLine().
                Split(' ').Select(int.Parse).ToArray();

            int difference = int.Parse(Console.ReadLine());


            int counter = 0;

            for (int num1 = 0; num1 < arr.Length; num1++)
            {
                for (int num2 = num1; num2 < arr.Length; num2++)
                {
                    if (Math.Abs(arr[num1] - arr[num2]) == difference)
                    {
                        counter++;
                    }

                }
            }

            Console.WriteLine(counter);

        }
    }
}
