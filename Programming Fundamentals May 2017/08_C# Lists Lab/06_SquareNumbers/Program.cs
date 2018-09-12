using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_SquareNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var result = new List<int>();

            foreach (var num in nums)
            {

                if (Math.Sqrt(num) == (int)(Math.Sqrt(num)))
                {
                    result.Add(num);
                }
            }

            result.Sort();
            result.Reverse();

            Console.WriteLine(string.Join(" ", result));

        }
    }
}
