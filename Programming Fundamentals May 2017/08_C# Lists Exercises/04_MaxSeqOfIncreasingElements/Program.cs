using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_MaxSeqOfIncreasingElements
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split().Select(int.Parse).ToArray();

            var longestIncreasingSubSequence = FindLongestIncreasingSubsequence(nums);

            Console.WriteLine(string.Join(" ", longestIncreasingSubSequence));

        }

        private static int[] FindLongestIncreasingSubsequence(int[] nums)
        {

            var lengths = new int[nums.Length];
            var previous = new int[nums.Length];

            var bestLength = 0;
            var lastIndex = -1;

            for (int anchor = 0; anchor < nums.Length; anchor++)
            {
                lengths[anchor] = 1;
                previous[anchor] = -1;

                var anchorNum = nums[anchor];
                for (int i = 0; i < anchor; i++)
                {
                    var currentNum = nums[i];
                    if (currentNum < anchorNum && lengths[i] + 1 > lengths[anchor])
                    {
                        lengths[anchor] = lengths[i] + 1;
                        previous[anchor] = i;
                    }
                }

                if (lengths[anchor] > bestLength)
                {
                    bestLength = lengths[anchor];
                    lastIndex = anchor;
                }
            }

            var longestIncreasingSubSeq = new List<int>();

            while (lastIndex != -1)
            {
                longestIncreasingSubSeq.Add(nums[lastIndex]);
                lastIndex = previous[lastIndex];
            }

            longestIncreasingSubSeq.Reverse();

            return longestIncreasingSubSeq.ToArray();

        }
    }
}
