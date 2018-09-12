using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_RoundingNumbersAwayFromZero
{
    class Program
    {
        static void Main(string[] args)
        {

           double[] nums = Console.ReadLine().
                Split(' ').Select(double.Parse).ToArray();

            int[] round = new int[nums.Length];

            for (int i = 0; i < nums.Length; i++)
            {

                round[i] = (int)Math.Round(nums[i], 
                    MidpointRounding.AwayFromZero);

            }

            for (int i = 0; i < nums.Length; i++)
            {
                Console.WriteLine($"{nums[i]} -> {round[i]}");
            }

        }
    }
}
