using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaxSequenceOfEqualElements
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().
                Split(' ').Select(int.Parse).ToList();

            var startIndex = 0;
            var seqLength = 1;

            var bestStartIndex = 0;
            var bestSeqLength = 0;

            for (int i = 1; i < nums.Count; i++)
            {

                if (nums[i] == nums[i - 1])
                {
                    seqLength++;
                    if (seqLength > bestSeqLength)
                    {
                        bestStartIndex = startIndex;
                        bestSeqLength = seqLength;
                    }
                }
                else
                {
                    startIndex = i;
                    seqLength = 1;
                }

            }

            if (bestSeqLength == 0 && bestStartIndex == 0)
            {
                Console.WriteLine(nums[0]);
                return;
            }

            for (int i = bestStartIndex; i < bestStartIndex + bestSeqLength; i++)
            {
                Console.Write(nums[i] + " ");
            }
            Console.WriteLine();

        }
    }
}
