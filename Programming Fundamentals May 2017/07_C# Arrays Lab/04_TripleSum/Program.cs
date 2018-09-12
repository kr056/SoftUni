using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_TripleSum
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] nums = Console.ReadLine().
                 Split(' ').Select(int.Parse).ToArray();

            int n = nums.Length;

            int triplesCounter = 0;
            int sum = 0;
            for (int a = 0; a < n; a++)
            {
                for (int b = a + 1; b < n; b++)
                {
                    sum = nums[a] + nums[b];

                    if (nums.Contains(sum))
                    {
                        triplesCounter++;
                        Console.WriteLine($"{nums[a]} + {nums[b]} == {sum}");
                    }

                }
            }
            if (triplesCounter == 0)
            {
                Console.WriteLine("No");
            }

        }
    }
}
