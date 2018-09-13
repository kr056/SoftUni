using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace _01_MostFrequenNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = File.ReadAllText("input3.txt").Split(' ');

            var nums = input.Select(int.Parse).ToArray();

            var count = new int[65540];

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


            File.WriteAllText("output3.txt", bestNum.ToString());
        }
    }
}
