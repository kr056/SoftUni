using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_ExtractMiddleElements
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] nums = Console.ReadLine().
              Split(' ').Select(int.Parse).ToArray();

            int middle = nums.Length / 2;

            if (nums.Length == 1)
            {
                Console.WriteLine(nums[0]);
            }
            else if (nums.Length % 2 == 0)
            {
                Console.WriteLine(string.Join(" ", nums[middle - 1], nums[middle]));
            }
            else if (nums.Length % 2 != 0)
            {
                Console.WriteLine(string.Join(" ", nums[middle - 1], nums[middle], nums[middle + 1]));

            }

        }
    }
}
