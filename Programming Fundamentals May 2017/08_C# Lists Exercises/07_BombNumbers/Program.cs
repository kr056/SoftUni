using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_BombNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            var bomb = Console.ReadLine().Split().Select(int.Parse).ToArray();

            var bombNum = bomb[0];
            var bombPower = bomb[1];

            for (int i = 0; i < nums.Count; i++)
            {
                var currentNum = nums[i];

                if (currentNum == bombNum)
                {
                    var leftIndex = Math.Max(i - bombPower, 0);
                    var rightIndex = Math.Min(i + bombPower, nums.Count - 1);

                    var removeCount = rightIndex - leftIndex + 1;

                    nums.RemoveRange(leftIndex, removeCount);

                    i = -1;
                }
            }

            int sum = nums.Sum();

            Console.WriteLine(string.Join(" ", sum));

        }
    }
}
