using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_SumReversedNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
      
            var nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            Reverse(nums);

        }

        static void Reverse(List<int> nums)
        {
            int result = 0;

            var final = new List<int>();

            for (int i = 0; i < nums.Count; i++)
            {
                while (nums[i] > 0)
                {
                    result = result * 10 + nums[i] % 10;
                    nums[i] /= 10;

                }
                final.Add(result);
                result = 0;
            }
            int sum = 0;

            for (int i = 0; i < final.Count; i++)
            {

                sum += final[i];
            }

            Console.WriteLine(sum);
        }
    }
}
