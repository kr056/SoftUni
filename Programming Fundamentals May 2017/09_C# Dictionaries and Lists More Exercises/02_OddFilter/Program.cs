using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_OddFilter
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            var evenNumbers = nums.Where(x => x % 2 == 0).ToList();

            var average = evenNumbers.Average();

            for (int i = 0; i < evenNumbers.Count; i++)
            {
                if (evenNumbers[i] <= average)
                {
                    evenNumbers[i]--;
                }
                else
                {
                    evenNumbers[i]++;
                }
            }

            Console.WriteLine(string.Join(" ", evenNumbers));
        }
    }
}
