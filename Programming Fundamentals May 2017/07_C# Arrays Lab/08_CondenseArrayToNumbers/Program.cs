using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_CondenseArrayToNumber
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] nums = Console.ReadLine().
               Split(' ').Select(int.Parse).ToArray();

            if (nums[0] == 1)
            {
                Console.WriteLine("1 is already condensed to number");
                return;
            }

            while (nums.Length > 1)
            {
                int[] condensedNums = new int[nums.Length - 1];

                for (int i = 0; i < condensedNums.Length; i++)
                {

                    condensedNums[i] = (nums[i] + nums[i + 1]);

                }
                nums = condensedNums;
            }

            Console.WriteLine(nums[0]);

        }
    }
}
