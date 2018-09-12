using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_Count_Real_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var nums = Console.ReadLine().Split().Select(double.Parse).ToArray();

            var result = new SortedDictionary<double, int>();

            foreach (var num in nums)
            {
                if (result.ContainsKey(num))
                {
                    result[num]++;
                }
                else
                {
                    result[num] = 1;
                }
            }

            foreach (var num in result.Keys)
            {
                Console.WriteLine("{0} -> {1}", num, result[num]);
            }
        }
    }
}
