using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_GrabAndGo
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split(' ').Select(long.Parse).ToList();

            var stop = long.Parse(Console.ReadLine());

            long sum = 0;

            bool thereIs = false;

            for (int i = nums.Count - 1; i >= 0; i--)
            {
                if (nums[i] == stop)
                {
                    thereIs = true;
                    for (int j = i - 1; j >= 0; j--)
                    {
                        sum += nums[j];
                    }
                    Console.WriteLine(sum);
                    return;
                }

            }
            if (!thereIs)
            {
                Console.WriteLine("No occurrences were found!");
            }
        }
    }
}
