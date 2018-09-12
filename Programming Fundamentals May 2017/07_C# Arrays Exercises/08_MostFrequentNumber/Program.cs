using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_MostFrequentNumber
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            var count =  new int[65540];

            var bestNum = 0;
            var bestCount = 0;

            foreach (var num in nums)
            {
                count[num]++;

                if (count[num] > bestCount)
                {
                    bestCount = count[num];
                    bestNum = num;
                }
            }

            Console.WriteLine(bestNum);

        }
    }
}
